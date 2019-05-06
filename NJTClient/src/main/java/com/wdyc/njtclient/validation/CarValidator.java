/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wdyc.njtclient.validation;

import com.wdyc.njtclient.constants.Constants;
import com.wdyc.njtclient.dto.CarDTO;
import com.wdyc.njtclient.rest.ws.RestWSClient;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Dusan
 */
public class CarValidator {

    private static CarValidator instance;

    public static CarValidator getInstance() {
        if (instance == null) {
            instance = new CarValidator();
        }
        return instance;
    }

    public boolean validateRegistration(String registration, String perform) {

        registration = registration.toUpperCase();
        registration = registration.trim();

        if (perform.equalsIgnoreCase("add_repair") || perform.equalsIgnoreCase("update_repair")) {
            try {
                RestWSClient.getInstance().setTarget(Constants.CARS_PATH);
                CarDTO car = (CarDTO) RestWSClient.getInstance().getByParameter_JSON(CarDTO.class, Constants.CARS_REGISTRATION_PARAM, registration);
                if (car.getOwner().getTip().equalsIgnoreCase("C")) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception ex) {
                return false;
            }
        } else if (perform.equalsIgnoreCase("add_car")) {
            try {
                RestWSClient.getInstance().setTarget(Constants.CARS_PATH);
                RestWSClient.getInstance().getByParameter_JSON(CarDTO.class, Constants.CARS_REGISTRATION_PARAM, registration);
                return false;
            } catch (Exception ex) {
                String regex = "^[A-Z]{2}-[0-9]{3,5}-[A-Z]{2}$";

                Pattern pattern = Pattern.compile(regex);

                Matcher matcher = pattern.matcher(registration);
                return matcher.matches();
            }
        } else if (perform.equalsIgnoreCase("update_car")) {
            String regex = "^[A-Z]{2}-[0-9]{3,5}-[A-Z]{2}$";

            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(registration);
            return matcher.matches();
        }
        return false;
    }

    public boolean validateColor(String color) {

        color = color.trim();

        String regex = "^[A-Za-z]{3,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(color);
        return matcher.matches();
    }

    public boolean validateVin(String vin) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 0, 1, 2, 3, 4, 5, 0, 7, 0, 9,
            2, 3, 4, 5, 6, 7, 8, 9};
        int[] weights = {8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2};

        String s = vin;
        s = s.replaceAll("-", "");
        s = s.replaceAll(" ", "");
        s = s.toUpperCase();
        if (s.length() != 17) {
            return false;
        }

        RestWSClient.getInstance().setTarget(Constants.CARS_PATH);

        try {
            RestWSClient.getInstance().getByParameter_JSON(CarDTO.class, Constants.CARS_VIN_PARAM, s);
            return false;
        } catch (Exception ex) {
            int sum = 0;
            for (int i = 0; i < 17; i++) {
                char c = s.charAt(i);
                int value;
                int weight = weights[i];

                // letter
                if (c >= 'A' && c <= 'Z') {
                    value = values[c - 'A'];
                    if (value == 0) {
                        throw new RuntimeException("Illegal character: " + c);
                    }
                } // number
                else if (c >= '0' && c <= '9') {
                    value = c - '0';
                } // illegal character
                else {
                    throw new RuntimeException("Illegal character: " + c);
                }

                sum = sum + weight * value;

            }

            // check digit
            sum = sum % 11;
            char check = s.charAt(8);
            if (sum == 10 && check == 'X') {
                System.out.println("Valid");
                return true;
            } else if (sum == transliterate(check)) {
                System.out.println("Valid");
                return true;
            } else {
                System.out.println("Invalid");
                return false;
            }
        }
    }

    private static int transliterate(char check) {
        if (check == 'A' || check == 'J') {
            return 1;
        } else if (check == 'B' || check == 'K' || check == 'S') {
            return 2;
        } else if (check == 'C' || check == 'L' || check == 'T') {
            return 3;
        } else if (check == 'D' || check == 'M' || check == 'U') {
            return 4;
        } else if (check == 'E' || check == 'N' || check == 'V') {
            return 5;
        } else if (check == 'F' || check == 'W') {
            return 6;
        } else if (check == 'G' || check == 'P' || check == 'X') {
            return 7;
        } else if (check == 'H' || check == 'Y') {
            return 8;
        } else if (check == 'R' || check == 'Z') {
            return 9;
        } else if (Integer.valueOf(Character.getNumericValue(check)) != null) {
            return Character.getNumericValue(check);
        }
        return -1;
    }

    public boolean validateCar(CarDTO car, String perform) {
        if (perform.equalsIgnoreCase("update_car")) {
            return validateRegistration(car.getRegistration(), perform) && validateColor(car.getColor());
        } else {
            return validateVin(car.getVin()) && validateRegistration(car.getRegistration(), perform)
                    && validateColor(car.getColor());
        }
    }

}
