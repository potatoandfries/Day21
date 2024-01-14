package vttp2023.batch4.paf.day21.Repo;

public class Queries {
    
    public static final String SQL_SELECT_ALL_BOOKS = """
            select * from book2018;
            """;


    // we also wanna queries w prepared statments*
    // finding books by id*
    public static final String SQL_SELECT_BOOK_BY_BOOKID= """
            select * 
            from book2018
            where book_id = ?

            """;

    public static final String SQL_SELECT_BOOK_BY_FORMAT_AND_RATING = """
            select *
            from book2018
            where format= ? and rating > ?
            """;
}
