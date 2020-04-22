package library;

import library.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class BookListViewHandler {


    @Autowired
    private BookListRepository bookListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRegistered_then_CREATE_1 (@Payload Registered registered) {
        try {
            if (registered.isMe()) {
                // view 객체 생성
                BookList bookList = new BookList();
                // view 객체에 이벤트의 Value 를 set 함
                bookList.setId(registered.getId());
                bookList.setBookName(registered.getBookName());
                // view 레파지 토리에 save
                bookListRepository.save(bookList);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenReturned_then_UPDATE_1(@Payload Returned returned) {
        try {
            if (returned.isMe()) {
                // view 객체 조회
                Optional<BookList> bookListOptional = bookListRepository.findById(returned.getId());
                if( bookListOptional.isPresent()) {
                    BookList bookList = bookListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookList.setBookStatus(returned.getBookStatus());
                    // view 레파지 토리에 save
                    bookListRepository.save(bookList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReserved_then_UPDATE_2(@Payload Reserved reserved) {
        try {
            if (reserved.isMe()) {
                // view 객체 조회
                Optional<BookList> bookListOptional = bookListRepository.findById(reserved.getId());
                if( bookListOptional.isPresent()) {
                    BookList bookList = bookListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookList.setBookStatus(reserved.getBookStatus());
                    // view 레파지 토리에 save
                    bookListRepository.save(bookList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenReservationCanceled_then_UPDATE_3(@Payload ReservationCanceled reservationCanceled) {
        try {
            if (reservationCanceled.isMe()) {
                // view 객체 조회
                Optional<BookList> bookListOptional = bookListRepository.findById(reservationCanceled.getId());
                if( bookListOptional.isPresent()) {
                    BookList bookList = bookListOptional.get();
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    bookList.setBookStatus(reservationCanceled.getBookStatus());
                    // view 레파지 토리에 save
                    bookListRepository.save(bookList);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}