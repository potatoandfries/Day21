package vttp2023.batch4.paf.day21;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import vttp2023.batch4.paf.day21.model.Book;

public class Utils {
    
    public static Book toBook (SqlRowSet rs){

        Book b = new Book();
        b.setBook_id(rs.getString("book_id"));
        b.setTitle(rs.getString("title"));
        b.setAuthors(rs.getString("authors"));
        b.setDescription(rs.getString("description"));
        b.setEdition(rs.getString("edition"));
        b.setFormat(rs.getString("format"));
        b.setPages(rs.getInt("pages"));
        b.setRating(rs.getFloat("rating"));
        b.setRating_count(rs.getInt("rating_count"));
        b.setReview_count(rs.getInt("review_count"));
        b.setGenres(rs.getString("genres"));
        b.setImage_url(rs.getString("image_url"));
        return b;
    }
}
