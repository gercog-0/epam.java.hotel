package by.epam.project.model.dao;

import by.epam.project.entity.Entity;
import by.epam.project.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BaseDaoSql<T extends Entity> {
    Logger logger = LogManager.getLogger();

    boolean add(T t) throws DaoException;

    List<T> findAll() throws DaoException;

    default void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException exp) {
                logger.error("Closing statement error", exp);
            }
        }
    }

    default void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException exp) {
                logger.error("Closing resultSet error", exp);
            }
        }
    }
}
