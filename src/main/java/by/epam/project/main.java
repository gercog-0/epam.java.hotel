package by.epam.project;

import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.util.DateUtil;

import java.text.ParseException;


public class main {
    public static void main(String[] args) throws DaoException, ServiceException, ParseException {
        System.out.println(DateUtil.parseDateStringToMilliseconds("2021-10-23"));
    }
}

