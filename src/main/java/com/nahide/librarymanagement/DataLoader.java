package com.nahide.librarymanagement;

import com.nahide.librarymanagement.models.*;
import com.nahide.librarymanagement.repositories.*;
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
    private final AuthorRepository authorRepository;
    private final BorrowerRepository borrowerRepository;

    public DataLoader(BookRepository bookRepository, GenreRepository genreRepository, PublisherRepository publisherRepository, AuthorRepository authorRepository, BorrowerRepository borrowerRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.borrowerRepository = borrowerRepository;
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

     List<Author> authors = new ArrayList<>();
     authors.add(new Author(
             null,
             "Orhan",
             "Kemal",
             "Asıl adı Mehmet Raşit Öğütçü olan yazar, 1943’te İkdam Gazetesi’nde yayınlanan öyküsüyle birlikte Orhan Kemal imzasını kullanmaya başlar. Bunun dışında Yıldız Okur, Hayrullah Güçlü ve Raşit Kemali gibi takma isimleri de kullanmıştır.",
             "1943"
     ));

     authors.add(new Author(
             null,
             "Aziz",
             "Nesin",
             "Edebiyat tarihimiz boyunca en fazla takma isim kullanan yazar Aziz Nesin‘dir. Asıl adı Mehmet Nusret Nesin olan yazar, çeşitli dergi ve gazetelerde birbirinden farklı imzalar kullanarak metinler kaleme almıştır. Bu isimlerden bazıları Bahri Filefil, Berdi Birdirbir, Fettane Şatifil, Kerami Pestenkerani, Kerim Kihkih, Ord. Prof. Paf-Puf, Dr. Daim Değer, Oya Ateş, Vedia Nesin olarak bilinmektedi",
             "1940"
     ));

     authors.add(new Author(
             null,
             "Kemal",
             "Tahir",
             "Yazar, ilk olarak Yedigün ve Karikatür dergilerinde takma isimle şiirler kaleme alır. Asıl adı Kemal Tahir Demir‘dir. Ardından polisiye romanlar ve mizah öyküleri yazmaya başlayan yazar, 1954 yılına kadar Kemal Tahir imzasını eserlerinde kullanamaz. Yazar, 1950’li yıllarda Körduman, Bedri Eser, Samim Aşkın, F. M. İkinci, Nurettin Demir, Ali Gıcırlı gibi imzalarla birlikte yazın hayatını sürdürür.",
             "1930"
     ));

     authors.add(new Author(
             null,
             "Nazım Hikmet",
             "Ran",
             "Nazım Hikmet Ran, yasaklı olduğu yıllarda pek çok kez takma isim kullanarak yazılar kaleme almıştır. Bunlardan bazıları; Orhan Selim, Ahmet Oğuz Saruhan, Mümtaz Osman ve Ercüment Er olarak bilinir.",
             "1930"
     ));

     authors.forEach(authorRepository::save);

     List<Borrower> borrowers = new ArrayList<>();
     borrowers.add(new Borrower(
             null,
             "nadis",
             "Nahide",
             "Ergün"
     ));

     borrowers.add(new Borrower(
             null,
             "mnkskyaz",
             "Menekşe",
             "İlkyaz"
     ));

     borrowers.add(new Borrower(
             null,
             "molcay",
             "M. Olcay",
             "Tercanlı"
     ));

     borrowers.forEach(borrowerRepository::save);



    }
}
