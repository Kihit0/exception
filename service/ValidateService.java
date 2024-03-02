package homework.src.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidateService {


    private boolean isValidDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            format.setLenient(false);
            Date tryParseDate = format.parse(date);
            return true;
        } catch (ParseException e){
            System.out.println("Error: Неверный формат даты");
            return false;
        }


    }

    private boolean isValidPhoneNumber(String phone){
        try {
            int tryParsePhone = Integer.parseInt(phone);
            return true;
        } catch (NumberFormatException e){
            System.out.println("Error: Неверный формат номера телефона");
            return false;
        }


    }

    private boolean isValidGender(String gender){
        return gender.equals("f") || gender.equals("m");
    }
    private boolean validate(String data){

        String[] itemsData = data.split(" ");

        if(itemsData.length != 6 || data.isEmpty()){
            System.out.println("Error: Вы ввели не все данные");
            return false;
        }

        return isValidDate(itemsData[3]) && isValidPhoneNumber(itemsData[4]) && isValidGender(itemsData[5]);
    }

    public boolean init(String data){
        return this.validate(data);
    }
}
