public class DataStorage {
    //սա մեր հիմնական մասիվն է ,որտեղ պահելու ենք ավելացվող ելեմենտները
    private Book[] books = new Book[10];

    //սա մեր մասիվի մեջ ավելացված էլեմենտների քանակն է
    private int size = 0;

    //ստւգել եթե մասիվի մեջ տեղ չկա կանչել extend()
    //և ավելացնել
    public void add(Book value) {

        if (size < books.length) {
            books[size++] = value;
        } else {
            extend();
            books[size++] = value;
        }

    }

    //եթե տրված ինդեքսը մեր ունեցած մասիվի ինդեքսի սահմաններում է,վեռադարձնել
    // մասիվի index-երորդ  էլեմենտը հակառակ դեպքւմ վերեդերձնել -1:
    public Book getByIndex(int index) {
        if (index > 0 && index < books.length)
            return books[index];
        return null;
    }

    //1. ստեղծել հին մասիվց 10 էլեմենտ մեծ մասիվ
    //2. քցել հին մասիվի էլեմենտները նօրի մեջ
    //3. հին մասիվի հղւմը կապեմք նօռ մասիվի հղման հետ:
    private void extend() {
        Book temp[] = new Book[books.length + 10];
        System.arraycopy(books, 0, temp, 0, books.length);
    }


    public Book getBookByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equals(title)) {
                return books[i];
            }
        }
        return null;
    }

    public Book get(int index) {
        if(index<0||index>size){
            return null;
        }
        return books[index];
    }

    public void print() {

        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }
}
