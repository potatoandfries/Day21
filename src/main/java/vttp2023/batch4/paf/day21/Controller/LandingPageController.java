    package vttp2023.batch4.paf.day21.Controller;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PathVariable;
    import org.springframework.web.bind.annotation.RequestParam;
    import org.springframework.web.servlet.ModelAndView;

    import vttp2023.batch4.paf.day21.Repo.BookRepo;
    import vttp2023.batch4.paf.day21.Service.SummaryService;
    import vttp2023.batch4.paf.day21.model.Book;

    @Controller
    public class LandingPageController {

        @Autowired
        SummaryService svc;

        @Autowired
        BookRepo repo;


        @GetMapping(path={"/"})
        public ModelAndView getIndex(){ //show index page
            
            ModelAndView mav = new ModelAndView("landingPage.html");
            mav.addObject("BookList", svc.bookSummary(repo.findAllBooks()));
            return mav;
            
        }
        @GetMapping(path={"/search"})
        public ModelAndView showForm(@RequestParam String format,@RequestParam float ratings){
            
            ModelAndView mav = new ModelAndView("listing.html");
            mav.addObject("SearchBookList", repo.findBookbyFormatandRating(format,ratings));
            return mav;
            
        }
        @GetMapping(path="/book/{book_id}")
        public ModelAndView showBookDetails(@PathVariable("book_id") String book_id){

            ModelAndView mav = new ModelAndView("books.html");
            Book book = repo.findBookByid(book_id);
            mav.addObject("book", book);
            return mav;
        }

    }
