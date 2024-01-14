package vttp2023.batch4.paf.day21.Repo;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import vttp2023.batch4.paf.day21.Utils;
import vttp2023.batch4.paf.day21.model.Book;

@Repository
public class BookRepo {

    @Autowired
    private JdbcTemplate template;
    
    //simple crud operations
    //1.Select* <read> : ALL , bookid and then ratings+format.
    public Book findBookByid(String book_id){

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_BOOKID, book_id);  
       
        while (rs.next()){
            return Utils.toBook(rs); // Return the Book object when a match is found.
        }
    
        return null; // Return null if no match is found.
    }


    public List<Book> findAllBooks(){

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_ALL_BOOKS);
        List<Book> results = new LinkedList<>();
        
        while (rs.next()){
            results.add(Utils.toBook(rs));
        }
        
        // If no books were found, you can return an empty list.
        return results;
    }

    public List<Book> findBookbyFormatandRating(String format, float ratings){

        SqlRowSet rs = template.queryForRowSet(Queries.SQL_SELECT_BOOK_BY_FORMAT_AND_RATING,format,ratings);
        List<Book> results = new LinkedList<>();

        while (rs.next()){
            results.add(Utils.toBook(rs));
        }
        return results;
    }

}
