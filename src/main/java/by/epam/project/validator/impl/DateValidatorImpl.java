package by.epam.project.validator.impl;

import by.epam.project.util.DateUtil;
import by.epam.project.validator.BaseValidator;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

public class DateValidatorImpl implements BaseValidator {
    private static final int DATE_YEAR_INDEX = 0;
    private static final int DATE_MONTH_INDEX = 1;
    private static final int DATE_DAY_INDEX = 2;
    private static final String DATE_REGEX = "^\\d{4}\\-\\d{2}\\-\\d{2}$";
    private static final String DATE_REGEX_DELIMITER = "-";
    private static final int LOW_BORDER_MONTH_AND_DAY = 1;
    private static final int LOW_BORDER_YEAR = 2020;
    private static final int HIGH_BORDER_YEAR = 2050;
    private static final int HIGH_BORDER_MONTH = 12;
    private static final int HIGH_BORDER_DAY = 31;


    private static final DateValidatorImpl instance = new DateValidatorImpl();

    private DateValidatorImpl() {
    }

    public static DateValidatorImpl getInstance() {
        return instance;
    }

    public boolean checkDate(String arrivalDate, String departureDate) {
        boolean isCorrect = false;
        Date currentDay = DateUtil.takeCurrentDateFormat();
        if (isStringMatches(arrivalDate, DATE_REGEX) && isStringMatches(departureDate, DATE_REGEX)) {
            if (validateDateValues(arrivalDate) && validateDateValues(departureDate)) {
                Optional<Date> arrivalDateFormatOptional = DateUtil.parseStringToDateFormat(arrivalDate);
                Optional<Date> departureDateFormatOptional = DateUtil.parseStringToDateFormat(departureDate);
                if (arrivalDateFormatOptional.isPresent() && departureDateFormatOptional.isPresent()) {
                    Date arrivalDateFormat = arrivalDateFormatOptional.get();
                    Date departureDateFormat = departureDateFormatOptional.get();
                    if (compareDates(currentDay, arrivalDateFormat, departureDateFormat)) {
                        isCorrect = true;
                    }
                }
            }
        }
        return isCorrect;
    }

    private boolean compareDates(Date currentDate, Date arrivalDate, Date departureDate) {
        boolean isCorrect = false;
        if ((currentDate.before(arrivalDate) || currentDate.equals(arrivalDate))
                && currentDate.before(departureDate) && arrivalDate.before(departureDate)) {
            isCorrect = true;
        }
        return isCorrect;
    }

    private boolean validateDateValues(String date) {
        String[] partsDate = date.split(DATE_REGEX_DELIMITER);
        int year = Integer.parseInt(partsDate[DATE_YEAR_INDEX]);
        int month = Integer.parseInt(partsDate[DATE_MONTH_INDEX]);
        int day = Integer.parseInt(partsDate[DATE_DAY_INDEX]);

        return isYearCorrect(year) && isMonthCorrect(month) && isDayCorrect(day);
    }

    private boolean isYearCorrect(int year) {
        return LOW_BORDER_YEAR <= year && year <= HIGH_BORDER_YEAR;
    }

    private boolean isMonthCorrect(int month) {
        return LOW_BORDER_MONTH_AND_DAY <= month && month <= HIGH_BORDER_MONTH;
    }

    private boolean isDayCorrect(int day) {
        return LOW_BORDER_MONTH_AND_DAY <= day && day <= HIGH_BORDER_DAY;
    }

    @Override
    public boolean defineIncorrectValues(Map<String, String> data) {
        return false;
    }
}
