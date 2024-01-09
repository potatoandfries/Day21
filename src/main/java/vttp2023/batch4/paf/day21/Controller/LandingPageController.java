package vttp2023.batch4.paf.day21.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import vttp2023.batch4.paf.day21.Repo.BookRepository;
import vttp2023.batch4.paf.day21.model.Book;

@Controller
public class LandingPageController {
    

    @Autowired
    BookRepository bookRepo;

    @GetMapping("/")
    public ModelAndView showLandingPage() {
        // show the landing page.
        ModelAndView mav = new ModelAndView("landingPage");
        //i already attached modeled the data in the repo.
        List<Book> bookList = bookRepo.findAllBook();
        // tell them what is what for thymeleaf to show.
        mav.addObject("BookList", bookList);
        return mav;
    }
    //this shit you learn from SSF assessment
    @GetMapping("/book/{title}")
    public ModelAndView showBookDetails(@PathVariable("title") String title) {
    ModelAndView mav = new ModelAndView("books"); // Assuming you have a view named "bookDetails".
    Book book = bookRepo.findBooksByTitle(title);
    mav.addObject("book", book);
    System.out.println(book.getBook_id());
    return mav;
}
}

