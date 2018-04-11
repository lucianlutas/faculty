package Repository;

import DataAccess.UserDAO;
import Model.User;
import net.proteanit.sql.DbUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class UsersBLL {

    public TableModel populateCashiers(){
        UserDAO userDAO = new UserDAO();
        TableModel model = null;
        model = userDAO.populate(1);

        return model;
    }

    // Return 2 for ADMIN, 1 for CASHIER, 0 for NON-EXISTENT
    public static int checkLogin(String username, String password){

        UserDAO userDAO = new UserDAO();

        User user = userDAO.read(username);

        if(user != null){
            try {
                if(user.getPass().equals(encrypt(password,"Lemon"))){
                    return user.getType();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return 0;
    }

    public static boolean addAdmin(String usern, String pass){
        UserDAO userDAO = new UserDAO();
        User user = new User();

        user.setType(2);
        user.setUsername(usern);
        user.setPass(pass);

        userDAO.create(user);

        return true;
    }

    public static boolean removeCashier(String username){
        UserDAO userDAO = new UserDAO();
        User user = null;

        if(username != null && username.length() > 0){
            user = userDAO.read(username);
            userDAO.delete(user.getId());
            return true;
        }

        return false;
    }

    public static boolean updateCashier(String username, String newUser, String newPass){
        UserDAO userDAO = new UserDAO();
        User user = null;

        if(newUser != null && newUser.length() > 0){
            if(newPass != null && newPass.length() > 0){
                user = userDAO.read(username);
                user.setUsername(newUser);
                try {
                    user.setPass(encrypt(newPass, "Lemon"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                userDAO.update(user);
                return true;
            }
        }

        return false;
    }

    public static boolean addCashier(String username, String pass){
        UserDAO userDAO = new UserDAO();
        User user = new User();

        if(username != null && username.length() > 0){
            if(pass != null && pass.length() > 0) {
                user.setId(userDAO.getSize());
                user.setUsername(username);
                try {
                    user.setPass(encrypt(pass,"Lemon"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                user.setType(1);
                if (!userDAO.exists(username)) {
                    userDAO.create(user);

                    return true;
                }
            }
        }

        return false;
    }

    public static String encrypt(String strClearText,String strKey) throws Exception{
        String strData="";

        try {
            SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"Blowfish");
            Cipher cipher=Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
            byte[] encrypted=cipher.doFinal(strClearText.getBytes());
            strData=new String(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e);
        }
        return strData;
    }

}
