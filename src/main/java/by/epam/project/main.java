package by.epam.project;

import by.epam.project.entity.Booking;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.util.DateUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class main {
    public static void main(String[] args) throws DaoException, ServiceException {
        Date date = DateUtil.parseMillisecondsToDate(1602709200000L);
    }
}

