package by.epam.project.validator.impl;

import by.epam.project.validator.BaseValidator;

import java.util.HashMap;
import java.util.Map;

import static by.epam.project.util.RequestParameterName.*;

public class PaymentCardValidatorImpl implements BaseValidator {
    private static final String NUMBER_CARD_REGEX = "^[\\d]{4}\\s[\\d]{4}\\s[\\d]{4}\\s[\\d]{4}$";
    private static final String DATE_CARD_REGEX = "^([1-9]|1[0-2])\\/([1-9]|2[0-9])$";
    private static final String CV_CARD_CODE_REGEX = "^[\\d]{3}$";
    private static final String TRANSFER_AMOUNT_REGEX = "^\\d+\\.?\\d+$";
    private static final double MIN_TRANSFER_AMOUNT = 100;
    private static final double MAX_TRANSFER_AMOUNT = 100000;

    private static final PaymentCardValidatorImpl instance = new PaymentCardValidatorImpl();

    private PaymentCardValidatorImpl() {
    }

    public static PaymentCardValidatorImpl getInstance() {
        return instance;
    }


    public Map<String, String> validateParameters(String number, String date, String cvCode, String transferAmount) {
        Map<String, String> validateData = new HashMap<>();
        validateData.put(NUMBER_CARD, isNumberCardCorrect(number) ? number : EMPTY_STRING);
        validateData.put(DATE_CARD, isDateCardCorrect(date) ? date : EMPTY_STRING);
        validateData.put(CV_CODE_CARD, isCvCardCodeCorrect(cvCode) ? cvCode : EMPTY_STRING);
        validateData.put(TRANSFER_AMOUNT_CARD, isTransferAmountCorrect(transferAmount)
                ? transferAmount : EMPTY_STRING);
        return validateData;
    }

    private boolean isNumberCardCorrect(String numberCard) {
        return isEmptyOrNull(numberCard) && isStringMatches(numberCard, NUMBER_CARD_REGEX);
    }

    private boolean isDateCardCorrect(String dateCard) {
        return isEmptyOrNull(dateCard) && isStringMatches(dateCard, DATE_CARD_REGEX);
    }

    private boolean isCvCardCodeCorrect(String cvCardCode) {
        return isEmptyOrNull(cvCardCode) && isStringMatches(cvCardCode, CV_CARD_CODE_REGEX);
    }

    private boolean isTransferAmountCorrect(String transferAmount) {
        if (isStringMatches(transferAmount, TRANSFER_AMOUNT_REGEX)) {
            double value = Double.parseDouble(transferAmount);
            if (MIN_TRANSFER_AMOUNT <= value && value <= MAX_TRANSFER_AMOUNT) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean defineIncorrectValues(Map<String, String> data) {
        for (String key : data.keySet()) {
            if (data.get(key).isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
