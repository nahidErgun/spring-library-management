package com.nahide.librarymanagement;

import com.nahide.librarymanagement.models.Book;
import com.nahide.librarymanagement.models.Genre;
import com.nahide.librarymanagement.models.Publisher;
import com.nahide.librarymanagement.repositories.BookRepository;
import com.nahide.librarymanagement.repositories.GenreRepository;
import com.nahide.librarymanagement.repositories.PublisherRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final PublisherRepository publisherRepository;

    public DataLoader(BookRepository bookRepository, GenreRepository genreRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
       List<Book> books = new ArrayList<>();
        books.add(new Book(
                null,
                "Harry Potter ve Felsefe Taşı",
                "Fantastik",
                "J. K. Rowling",
                "1997",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Felsefe Taşı açıklama"
        ));

        books.add(new Book(
                null,
                "Harry Potter ve Sırlar Odası",
                "Fantastik",
                "J. K. Rowling",
                "1998",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Sırlar Odası açıklama"
        ));

        books.add(new Book(
                null,
                "Harry Potter ve Azkaban Tutsağı",
                "Fantastik",
                "J. K. Rowling",
                "1999",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Azkaban Tutsağı açıklama"
        ));

        books.add(new Book(
                null,
                "Harry Potter ve Ateş Kadehi",
                "Fantastik",
                "J. K. Rowling",
                "2000",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Ateş Kadehi açıklama"
        ));

        books.add(new Book(
                null,
                "Harry Potter ve Zümrüdüanka Yoldaşlığı",
                "Fantastik",
                "J. K. Rowling",
                "2003",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Zümrüdüanka Yoldaşlığı açıklama"
        ));

        books.add(new Book(
                null,
                "Harry Potter ve Melez Prens",
                "Fantastik",
                "J. K. Rowling",
                "2005",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Melez açıklama"
        ));

        books.add(new Book(
                null,
                "Harry Potter ve Ölüm Yadigarları",
                "Fantastik",
                "J. K. Rowling",
                "2007",
                "Yapı Kredi Yayınları",
                "Available",
                "Harry Potter ve Ölüm Yadigarları açıklama"
        ));

        books.add(new Book(
                null,
                "Yüzüklerin Efendisi: Yüzük Kardeşliği",
                "Fantastik Kurgu",
                "J. R. R. Tolkien",
                "1954",
                "Metis Yayınları",
                "Available",
                "Yüzüklerin Efendisi: Yüzük Kardeşliği açıklama"
        ));

        books.add(new Book(
                null,
                "Yüzüklerin Efendisi: İki Kule",
                "Fantastik Kurgu",
                "J. R. R. Tolkien",
                "1954",
                "Metis Yayınları",
                "Available",
                "Yüzüklerin Efendisi: İki Kule açıklama"
        ));

        books.add(new Book(
                null,
                "Yüzüklerin Efendisi: Kralın Dönüşü",
                "Fantastik Kurgu",
                "J. R. R. Tolkien",
                "1955",
                "Metis Yayınları",
                "Available",
                "Yüzüklerin Efendisi: Kralın Dönüşü açıklama"
        ));

        books.forEach(bookRepository::save);


        List<Genre> genres = new ArrayList<>();
        genres.add(new Genre(
                null,
                "Fantastik"
        ));

        genres.add(new Genre(
                null,
                "Polisiye"
        ));

        genres.add(new Genre(
                null,
                "Psikoloji"
        ));

        genres.add(new Genre(
                null,
                "Roman"
        ));

        genres.add(new Genre(
                null,
                "Öykü"
        ));

        genres.add(new Genre(
                null,
                "Şiir"
        ));

        genres.forEach(genreRepository::save);


        List<Publisher> publishers = new ArrayList<>();
        publishers.add(new Publisher(
                null,
                "A Kadro Yayınları"
        ));

        publishers.add(new Publisher(
                null,
                "Aba Yayınları"
        ));

        publishers.add(new Publisher(
                null,
                "Ak Kitap"
        ));

        publishers.add(new Publisher(
                null,
                "Akademi Çocuk"
        ));

        publishers.add(new Publisher(
                null,
                "Akademik Arge"
        ));

        publishers.add(new Publisher(
                null,
                "İş Bankası Yayınları"
        ));

        publishers.add(new Publisher(
                null,
                "Yapı Kredi Yayınları"
        ));
        publishers.forEach(publisherRepository::save);

    }
}
