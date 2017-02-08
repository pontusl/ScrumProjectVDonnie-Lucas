/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrumproject;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.io.*;
import java.sql.*;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class Validation {

    private static String user;
    private static boolean isAdmin = false;
    public static InfDB idb;

    public Validation() {
        try {
            //Connects to database with an absolute path
            Path con = Paths.get("ScrumProject.FDB").toRealPath(LinkOption.NOFOLLOW_LINKS);
            idb = new InfDB(con.toString());
        } catch (InfException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static void setLoggedInUser(String loggedIn) {
        user = loggedIn;
    }

    public static String getLoggedInUser() {
        return user;
    }

    public static void setAdmin() {
        String sql = "select isAdmin from EMPLOYEE where Employee.EMAIL = '" + user + "'";
        String one = "1";
        String zero = "0";
        try {
            String admin = idb.fetchSingle(sql);
            if (admin.equals(zero)) {
                isAdmin = false;
            } else if (admin.equals(one)) {
                isAdmin = true;
            }
        } catch (Exception e) {

        }
    }

    //Sets true if admin logs in
    public static boolean getAdmin() {
        return isAdmin;
    }

    public static String getIdInlogged() {
        String id = "";
        String sql = "Select EMPLOYEEID from EMPLOYEE where EMAIL = '" + user + "'";
        try {
            id = idb.fetchSingle(sql);

        } catch (Exception e) {

        }

        return id;
    }

    //Checks if a textfield is empty
    public boolean checkIfTxtIsEmpty(String textfalt) {
        boolean isEmpty = false;

        if (textfalt.isEmpty() || textfalt == "") {
            isEmpty = true;
        }
        return isEmpty;
    }

    public boolean checkLogin(String user, String password) {
        boolean loginMatch = false;
        //SQL koden som hämtar ut raden som stämmer överrens med vad användaren matat in. 
        String sql = "select email, pW from EMPLOYEE where Employee.EMAIL = '" + user + "' and Employee.PW = '" + password + "'";

        try {
            HashMap<String, String> loggin = idb.fetchRow(sql);
            //Kollar om inloggningsuppgifterna stämmer överrens med databasen. Om det gör det sätts boolean loginMatch till true.
            //Matchar inloggningsuppgifterna med databasen kommer användaren få tillgång till administratör sidorna inom systemet.
            if (user.equals(loggin.get("EMAIL")) && password.equals(loggin.get("PW"))) {
                loginMatch = true;
            }
        } catch (Exception e) {

        }
        return loginMatch;
    }

    public void getCategoryComboBox(JComboBox combo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        //Sätt rowcount till 0 för att nolla/tömma comboboxens modell.
        model.removeAllElements();

        String sqlCategory = "select CATEGORY, CategoryID from CATEGORY";

        try {
            ArrayList<HashMap<String, String>> Category = idb.fetchRows(sqlCategory); //Skapar en Arraylist
            combo.addItem("Välj kategori");

            for (int i = 0; i < Category.size(); i++) { //Loopar igenom Arraylistan
                combo.addItem(Category.get(i).get("CATEGORY"));
            }

        } catch (InfException e) {

            JOptionPane.showMessageDialog(null, "Kunde inte hämta projektledare från databasen.");
        }
    }

    public void getEmployeeComboBox(JComboBox combo) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) combo.getModel();
        //Sätt rowcount till 0 för att nolla/tömma comboboxens modell.
        model.removeAllElements();

        String sqlEmployee = "select EMAIL, EmployeeID from EMPLOYEE";

        try {
            ArrayList<HashMap<String, String>> Employee = idb.fetchRows(sqlEmployee); //Skapar en Arraylist
            combo.addItem("Välj Anställd");

            for (int i = 0; i < Employee.size(); i++) { //Loopar igenom Arraylistan
                combo.addItem(Employee.get(i).get("EMAIL"));
            }

        } catch (InfException e) {

            JOptionPane.showMessageDialog(null, "Kunde inte hämta projektledare från databasen.");
        }
    }

    public boolean checkCurrentDate(java.util.Date datum) {
        boolean beforeTodaysDate = false;
        long millis = System.currentTimeMillis(); //- 1 * 24 * 60 * 60 * 1000; //Subtraherar 1 dag i millisekunder för att det ska vara okej att ta dagens datum men inte tidigare
        java.util.Date todaysDate = new java.util.Date(millis);//Instansierar Datumet

        if (todaysDate.after(datum)) {//Kollar om angivet datum är före dagens datum
            beforeTodaysDate = true;
        }

        return beforeTodaysDate;
    }

    public void CoBEmployeeName(JComboBox comboName) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboName.getModel();

        model.removeAllElements();

        String sqlAnstallda = "Select name, employeeID from employee";

        try {
            ArrayList<HashMap<String, String>> anvandareLista = idb.fetchRows(sqlAnstallda);

            for (int i = 0; i < anvandareLista.size(); i++) {
                String namn = anvandareLista.get(i).get("NAME");
                String id = anvandareLista.get(i).get("EMPLOYEEID");
                String row = namn + ", " + id;
                
                comboName.addItem(row);
                
            }

        } catch (Exception e) {

        }

    }

    public void CoBInvitedForMeeting(JComboBox comboName) {
        DefaultComboBoxModel model = (DefaultComboBoxModel) comboName.getModel();

        String userId = getIdInlogged();

        model.removeAllElements();

        String sql = "Select distinct meetingname from Meeting join invitedemployee on meeting.meetingId = invitedemployee.meetingsId \n"
                + "join employee on invitedemployee.employeesId = employee.employeeId \n"
                + "where EMPLOYEE.EMPLOYEEID = " + userId + " or\n"
                + "MEETING.ISADMINMEETING = " + userId + "";

        try {
            ArrayList<HashMap<String, String>> anvandareLista = idb.fetchRows(sql);

            for (int i = 0; i < anvandareLista.size(); i++) {
                comboName.addItem(anvandareLista.get(i).get("MEETINGNAME"));
            }

        } catch (Exception e) {

        }
    }

    public boolean CheckIfAdminForMeeting(String item) {
        boolean isAdminMeeting = false;
        String sql = "Select isadminmeeting from Meeting where meetingname = '" + item + "'";
        try {
            String t = idb.fetchSingle(sql);
            if (t == null || t.equals("")) {
                isAdminMeeting = false;
            } else {
                isAdminMeeting = true;
            }
        } catch (Exception e) {

        }
        return isAdminMeeting;
    }

    public boolean checkIfMeetingNameExists(String input) {
        boolean nameExists = false;
        String sql = "select MeetingName from Meeting where MeetingName = '" + input + "'";
        try {

            String dbName = idb.fetchSingle(sql);
            if (dbName != null) {
                nameExists = true;
            }
        } catch (Exception e) {
        }
        return nameExists;
    }

    public String getVoteResult(String item) {
        String noResult = "Admin för mötet har ej valt en tid!";
        try {
            String sql = "select datetime as Datum, timehour as Tid from times \n"
                    + "join INVITATIONFORMEETING on INVITATIONFORMEETING.TIMESID = times.TIMEID\n"
                    + "JOIN MEETING on INVITATIONFORMEETING.EMPLOYEESID = MEETING.ISADMINMEETING \n"
                    + "and INVITATIONFORMEETING.MEETINGSID = MEETING.MEETINGID\n"
                    + "where MEETING.MEETINGNAME = '" + item + "'";

            ArrayList<HashMap<String, String>> chosenTime = idb.fetchRows(sql);
            noResult = chosenTime.toString();

        } catch (Exception e) {
        }
        return noResult;
    }

    public boolean getAdminVoteResult(String item) {
        boolean adminVoted = false;
        try {
            String sql = "select datetime as Datum, timehour as Tid from times \n"
                    + "join INVITATIONFORMEETING on INVITATIONFORMEETING.TIMESID = times.TIMEID\n"
                    + "JOIN MEETING on INVITATIONFORMEETING.EMPLOYEESID = MEETING.ISADMINMEETING \n"
                    + "and INVITATIONFORMEETING.MEETINGSID = MEETING.MEETINGID\n"
                    + "where MEETING.MEETINGNAME = '" + item + "'";

            ArrayList<HashMap<String, String>> chosenTime = idb.fetchRows(sql);
            if (chosenTime.toString().equals("") || chosenTime == null) {
                adminVoted = false;
            } else {
                adminVoted = true;
            }

        } catch (Exception e) {
        }
        return adminVoted;
    }
    
    public boolean checkNullInvites(int employee){
        boolean empty = true;
        if(employee == 0){
            empty = true;
        }else{
        empty = false;
        }
        return empty;
    }
    
    public String getUserName(String id) {
         
      String name = "";
      String sqlNamnUser = "Select name from employee where employeeid =" + id;
     try {
      name = idb.fetchSingle(sqlNamnUser);
     }
      catch (InfException e){
      
      }
      return name;
     }
    
    public boolean validateEmail(String emailStr) {
        
        String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        boolean matches = emailStr.matches(emailregex);
 
        return matches;
    }
    
    public boolean checkEmailExists(String mail){
     
         boolean exists = false;
         String sql = "Select EMAIL from EMPLOYEE where EMAIL = '" + mail + "'";
         
         try{
         String m = idb.fetchSingle(sql);
         if(m == null || m.equals("")) {
             exists = false;
         }else{
             exists = true;
         }
         }catch(Exception e){
         
         }
         return exists;
     }
    
    public String getUserEmail(String id) {
      String email = "";
      String sqlPassword = "Select EMAIL from employee where employeeid =" + id;
      try {
      email = idb.fetchSingle(sqlPassword);
      }
      catch (InfException e) {
      }
      return email;
      }
   
    
    public String getUserTelefon(String id) {
      String phone = ""; 
      String sqlPhone = "Select phone from employee where employeeid = " + id;
      try {
      phone = idb.fetchSingle(sqlPhone);
      }
      catch (InfException e) {
      }
      return phone;
      }
    
    public boolean categoryGotPosts(){
        boolean havePosts = false;
        
        
        return havePosts;
    }
    
    public boolean checkIfChosenIsAdmin(String chosenName) {
        boolean alreadyAdmin = false;
        String sql = "select isAdmin from EMPLOYEE where EMPLOYEEID = '" + chosenName + "'";
        String one = "1";
        String zero = "0";
        try {
            String admin = idb.fetchSingle(sql);
            if (admin.equals(zero)) {
                alreadyAdmin = false;
            } else if (admin.equals(one)) {
                alreadyAdmin = true;
            }
        } catch (Exception e) {

        }
        return alreadyAdmin;  
    }
}
