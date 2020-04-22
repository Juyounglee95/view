package library;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BookList_table")
public class BookList {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private String bookName;
        private String bookStatus;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public String getBookName() {
            return bookName;
        }

        public void setBookName(String bookName) {
            this.bookName = bookName;
        }
        public String getBookStatus() {
            return bookStatus;
        }

        public void setBookStatus(String bookStatus) {
            this.bookStatus = bookStatus;
        }

}
