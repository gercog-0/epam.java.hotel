package by.epam.project.tag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class PaginationRoomsTag extends TagSupport {
    private static final Logger LOGGER = LogManager.getLogger();

    private int quantityPages;
    private int pageNumber;

    public void setQuantityPages(int quantityPages) {
        this.quantityPages = quantityPages;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    @Override
    public int doStartTag() {
        try {
            for (int i = 1; i <= quantityPages; i++) {
                pageContext.getOut().write("<a href=\"DeluxeHotel?command=filter_rooms&listPage="
                        + i + "\" class=\"pagination__link\">" + i + "</a>");
            }
        } catch (IOException exp) {
            LOGGER.error("Error while writing to out stream");
        }
        return SKIP_BODY;
    }
}
