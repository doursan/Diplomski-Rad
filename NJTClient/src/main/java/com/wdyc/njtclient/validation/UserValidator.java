/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.validation;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.ClientDTO;
import com.wdyc.njtclient.dto.ShopDTO;
import com.wdyc.njtclient.dto.UserDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dusan
 */
public class UserValidator {

    private static UserValidator instance;

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean validateEmail(String email) {

        if (email == null) {
            return false;
        }

        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validateUsername(String username) {
        RestWSClient.getInstance().setTarget(Constants.USERS_PATH);
        if (username.length() < 5) {
            return false;
        } else {
            try {
                RestWSClient.getInstance().getByParameter_JSON(UserDTO.class, Constants.USER_USERNAME_PARAM, username);
                return false;
            } catch (Exception ex) {
                return true;
            }
        }
    }

    public boolean validateShopName(String name) {
        RestWSClient.getInstance().setTarget(Constants.SHOPS_PATH);
        if (name.length() < 5) {
            return false;
        } else {
            try {
                RestWSClient.getInstance().getByParameter_JSON(UserDTO.class, Constants.USER_SHOP_NAME_PARAM, name);
                return false;
            } catch (Exception ex) {
                return true;
            }
        }
    }

    public boolean validatePib(String pib) {
        if (pib.charAt(0) == '0') {
            return false;
        }
        try {
            int pibInt = Integer.parseInt(pib);
            return pibInt >= 100000010 && pibInt <= 999999999;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validateMaticni(String maticni) {
        if (maticni.charAt(0) == '0') {
            return false;
        }
        try {
            int maticniInt = Integer.parseInt(maticni);
            return maticniInt >= 10000001 && maticniInt <= 99999999;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    public boolean validateFirstOrLastName(String name) {
        String regex = "^[\\p{L}\\s.’\\-,]+$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[.,-@#$%^&+=])(?=\\S+$).{8,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public boolean validateJmbg(String jmbg) {
        String regex = "^(\\d{13})?$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(jmbg);
        if (!matcher.matches()) {
            return false;
        }

        String godinaString;
        int godina;
        switch (jmbg.charAt(4)) {
            case '0':
                godinaString = jmbg.substring(5, 7);
                godina = Integer.parseInt(godinaString);
                godina += 2000;
                break;
            case '9':
                godinaString = jmbg.substring(4, 7);
                godina = Integer.parseInt(godinaString);
                godina += 1000;
                break;
            default:
                return false;
        }

        if (godina > Year.now().getValue()) {
            return false;
        }
        int mesec;
        int dan;
        List<Integer> tridesetJedan = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> trideset = Arrays.asList(4, 6, 9, 11);
        if (jmbg.charAt(0) == '0') {
            dan = Character.getNumericValue(jmbg.charAt(1));
        } else {
            dan = Integer.parseInt(jmbg.substring(0, 2));
        }
        if (jmbg.charAt(2) == '0') {
            mesec = Character.getNumericValue(jmbg.charAt(3));
        } else {
            mesec = Integer.parseInt(jmbg.substring(2, 4));
        }
        if (mesec > 12 || dan > 31 || mesec == 0 || dan == 0) {
            return false;
        }
        if ((tridesetJedan.contains(mesec) && dan > 31)
                || (trideset.contains(mesec) && dan > 30)
                || (mesec == 2 && dan > 29)) {
            return false;
        }
        return true;
    }

    public boolean validateBuyer(String buyer) {
        RestWSClient.getInstance().setTarget(Constants.USERS_PATH);
        if (buyer.length() < 5) {
            return false;
        } else {
            try {
                UserDTO retrievedBuyer = RestWSClient.getInstance().getByParameter_JSON(UserDTO.class, Constants.USER_USERNAME_PARAM, buyer);
                if (retrievedBuyer.getTip().equalsIgnoreCase("C")) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean validateUser(UserDTO user, String confirmPassword, char type) {
        if (type == 'S') {
            ShopDTO shop = (ShopDTO) user;
            if (validateUsername(shop.getUsername()) && validateEmail(shop.getEmail()) && validateShopName(shop.getNaziv())
                    && validatePib(shop.getPib()) && validateMaticni(shop.getMaticni()) && validatePassword(shop.getPassword())
                    && validatePassword(confirmPassword)) {
                return user.getPassword().equals(confirmPassword);
            } else {
                return false;
            }
        } else {
            ClientDTO client = (ClientDTO) user;
            if (validateUsername(client.getUsername()) && validateEmail(client.getEmail()) && validateFirstOrLastName(client.getIme())
                    && validateFirstOrLastName(client.getPrezime()) && validateJmbg(client.getJmbg()) && validatePassword(client.getPassword())
                    && validatePassword(confirmPassword)) {
                return user.getPassword().equals(confirmPassword);
            } else {
                return false;
            }
        }
    }
}
