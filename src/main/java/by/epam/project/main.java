package by.epam.project;

import by.epam.project.model.entity.Booking;
import by.epam.project.model.entity.Room;
import by.epam.project.exception.DaoException;
import by.epam.project.exception.ServiceException;
import by.epam.project.util.DateUtil;
import by.epam.project.util.EncryptPassword;
import by.epam.project.util.PaginationUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


public class main {
    public static void main(String[] args) {
        int MAX_NOTES = 100;
        int SPLIT_NUM = 13;
        List<Integer> notes = new ArrayList<>(MAX_NOTES);

        // список из ста элементов
        for (int i = 0; i < MAX_NOTES; i++) {
            notes.add(i);
        }
        System.out.println(PaginationUtil.takeSplitListByPage(notes,13,16));
    }
}


