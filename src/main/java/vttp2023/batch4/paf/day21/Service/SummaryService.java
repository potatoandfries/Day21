package vttp2023.batch4.paf.day21.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;


import vttp2023.batch4.paf.day21.Repo.BookRepo;
import vttp2023.batch4.paf.day21.model.Book;

@Service
public class SummaryService {
    

    @Autowired
    BookRepo repo;


    public List<Book> bookSummary(List<Book> bookList) {
        List<Book> bookSummaryList = new LinkedList<>();
    
        for (Book book : bookList) {
            Book b = new Book();
            b.setBook_id(book.getBook_id());
            b.setTitle(book.getTitle());
            b.setAuthors(book.getAuthors());
            b.setFormat(book.getFormat());
            b.setRating(book.getRating());
    
            bookSummaryList.add(b);
        }
    
        return bookSummaryList;
    }
}
