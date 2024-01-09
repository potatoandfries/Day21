package vttp2023.batch4.paf.day21.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.RowMapper;

import vttp2023.batch4.paf.day21.model.Book;

@Repository
public class BookRepository {
   
   @Autowired
   private JdbcTemplate template;

   public void findBookByFormatAndRating(String format, float rating) {

      SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_FORMAT_AND_RATING
            , format, rating);  

      while (rs.next()) {
         String bookId = rs.getString("book_id");
         String title = rs.getString("title");
         String image = rs.getString("image_url");
         int pages = rs.getInt("pages");
         float _rating = rs.getFloat("rating");
         System.out.printf("%s, %s, %d, %.3f, %s\n", bookId, title, pages, _rating, image);
      }

      System.out.println("\n\nQuery completed");
   }

   public Book findBooksByTitle(String keyword) {
    String toSearch = keyword;

    SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_TITLE, toSearch);

    if (rs.next()) {
        Book book = new Book();
        book.setBook_id(rs.getString("book_id"));
        book.setTitle(rs.getString("title"));
        book.setAuthors(rs.getString("authors"));
        book.setDescription(rs.getString("description"));
        book.setEdition(rs.getString("edition"));
        book.setFormat(rs.getString("format"));
        book.setPages(rs.getInt("pages"));
        book.setRating(rs.getFloat("rating"));
        book.setRating_count(rs.getInt("rating_count"));
        book.setReview_count(rs.getInt("review_count"));
        book.setGenres(rs.getString("genres"));
        book.setImage_url(rs.getString("image_url"));
        return book;
    }

    return null; // If no book is found with the given title.
    }

    public List<Book> findAllBook() { 
        return template.query(Queries.SQL_SELECT_ALL_BOOK, new BookRowMapper());
    }

   private static class BookRowMapper implements RowMapper<Book> {
      @Override
      public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
         Book book = new Book();
         book.setBook_id(rs.getString("book_id"));
         book.setTitle(rs.getString("title"));
         book.setAuthors(rs.getString("authors"));
         book.setDescription(rs.getString("description"));
         book.setEdition(rs.getString("edition"));
         book.setFormat(rs.getString("format"));
         book.setPages(rs.getInt("pages"));
         book.setRating(rs.getFloat("rating"));
         book.setRating_count(rs.getInt("rating_count"));
         book.setReview_count(rs.getInt("review_count"));
         book.setGenres(rs.getString("genres"));
         book.setImage_url(rs.getString("image_url"));
         return book;
      }
   }
}