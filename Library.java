package library;
import java.util.Scanner;
class book {
public int sNo;
public String bookName;
public String authorName;
public int bookQty;
public int bookQtyCopy;
Scanner input = new Scanner(System.in);
public book(){
System.out.println("Enter the Serial Number of the Book: ");
this.sNo = input.nextInt();
input.nextLine();
System.out.println("Enter Book Name: ");
this.bookName = input.nextLine();
System.out.println("Enter Author Name: ");
this.authorName = input.nextLine();
System.out.println("Enter Quantity of the Books: ");
this.bookQty = input.nextInt();
bookQtyCopy = this.bookQty;
}
}
class books {
book theBooks[] = new book[50];
public static int count;
Scanner input = new Scanner(System.in);
public int compareBookObjects(book b1, book b2){
if (b1.bookName.equalsIgnoreCase(b2.bookName)){
System.out.println("Book of this Name Already Exists.");
return 0;
}
if (b1.sNo==b2.sNo) {
System.out.println("Book of this Serial Number Already Exists.");
return 0;
}

return 1;
}
public void addBook(book b){
for (int i=0; i<count; i++){
if (this.compareBookObjects(b, this.theBooks[i]) == 0)
return;
}
if (count<50){
theBooks[count] = b;
count++;
}
else{
System.out.println("No Space to Add More Books.");
}
}
public void searchBySno(){
System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");
int sNo;
System.out.println("Enter Serial No of Book: ");
sNo = input.nextInt();
int flag = 0;
System.out.println("S.No\t\t\tName\t\t\t\tAuthor\t\t\t\tAvailable
Qty\t\t\tTotal Qty");
for (int i=0; i<count; i++){
if (sNo == theBooks[i].sNo){
System.out.println(theBooks[i].sNo + "\t\t\t" + theBooks[i].bookName +
"\t\t\t" + theBooks[i].authorName + "\t\t\t" +
theBooks[i].bookQtyCopy + "\t\t\t\t" + theBooks[i].bookQty);
flag++;
return;
}
}
if (flag == 0)
System.out.println(" Book of Serial No. " + sNo + " Found.");
}
public void searchByAuthorName(){
System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
input.nextLine();
System.out.println("Enter Author Name: ");
String authorName = input.nextLine();
int flag = 0;

System.out.println("S.No\t\t\tName\t\t\t\tAuthor\t\t\t\tAvailable
Qty\t\t\tTotal Qty");
for (int i=0; i<count; i++){
if (authorName.equalsIgnoreCase(theBooks[i].authorName)){
System.out.println(theBooks[i].sNo + "\t\t\t" + theBooks[i].bookName +
"\t\t\t" + theBooks[i].authorName + "\t\t\t" +
theBooks[i].bookQtyCopy + "\t\t\t\t" + theBooks[i].bookQty);
flag++;
}
}
if (flag == 0)
System.out.println("The Book of " + authorName + " Found.");
}
public void showAllBooks(){
System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
System.out.println("S.No\t\t\tName\t\t\t\tAuthor\t\t\t\tAvailable
Qty\t\tTotal Qty");
for (int i=0; i<count; i++){
System.out.println(theBooks[i].sNo + "\t\t\t" + theBooks[i].bookName +
"\t\t\t" + theBooks[i].authorName + "\t\t\t" +
theBooks[i].bookQtyCopy + "\t\t\t" + theBooks[i].bookQty);
}
}
public void upgradeBookQty(){
System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
System.out.println("Enter Serial Number of the Book");
int sNo = input.nextInt();
for (int i=0; i<count; i++){
if (sNo == theBooks[i].sNo){
System.out.println("Enter Number of Books to be Added:");
int addingQty = input.nextInt();
theBooks[i].bookQty += addingQty;
theBooks[i].bookQtyCopy += addingQty;
return;
}
}
}
public void dispMenu(){
System.out.println("---------------------------------------------");
System.out.println("Enter 0 to Exit the Application.");
System.out.println("Enter 1 to Add new Book");

System.out.println("Enter 2 to Upgrade Quantity of a Book");
System.out.println("Enter 3 to Search a Book");
System.out.println("Enter 4 to Show All Books");
System.out.println("Enter 5 to Register Student");
System.out.println("Enter 6 to Show All Registered Students.");
System.out.println("Enter 7 to Check Out Book");
System.out.println("Enter 8 to Check In Book");
System.out.println("----------------------------------------------");
}
public int isAvailable(int sNo){
//returns the index number if available
for (int i=0; i<count; i++){
if (sNo == theBooks[i].sNo){
if(theBooks[i].bookQtyCopy > 0){
System.out.println("Book is Available.");
return i;
}
System.out.println("Book is Unavailable");
return -1;
}
}
System.out.println("No Book of Serial Number " + " Available in Library.");
return -1;
}
public book checkOutBook(){
System.out.println("Enter Serial Number of the Book to be Checked Out.");
int sNo = input.nextInt();
int bookIndex =isAvailable(sNo);
if (bookIndex!=-1){
theBooks[bookIndex].bookQtyCopy--;
return theBooks[bookIndex];
}
return null;
}
public void checkInBook(book b){
for (int i=0; i<count; i++){
if (b.equals(theBooks[i]) ){
theBooks[i].bookQtyCopy++;
return;
}
}

}
}
class student {
String studentName;
String regNum;
book borrowedBooks[] = new book[3];
public int booksCount = 0;
Scanner input = new Scanner(System.in);
public student(){
System.out.println("Enter Student Name: ");
this.studentName = input.nextLine();
System.out.println("Enter Reg Number: ");
this.regNum = input.nextLine();
}
}
class students {
Scanner input = new Scanner(System.in);
student theStudents[] = new student[50];;
public static int count = 0;
public void addStudent(student s){
for (int i=0; i<count; i++){
if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){
System.out.println("Student of Reg Num " + s.regNum + " is Already
Registered.");
return;
}
}
if (count<=50){
theStudents[count] = s;
count++;
}
}
public void showAllStudents(){
System.out.println("Student Name\t\t\tReg Number");
for (int i=0; i<count; i++){
System.out.println(theStudents[i].studentName + "\t\t\t" +
theStudents[i].regNum);
}
}

public int isStudent(){
System.out.println("Enter Reg Number:");
String regNum = input.nextLine();
for (int i=0; i<count; i++){
if (theStudents[i].regNum.equalsIgnoreCase(regNum)){
return i;
}
}
System.out.println("Student is not Registered.");
System.out.println("Get Registered First.");
return -1;
}
public void checkOutBook(books book){
int studentIndex =this.isStudent();
if (studentIndex!=-1){
System.out.println("Checking out");
book.showAllBooks();
book b = book.checkOutBook();
System.out.println("Checking out");
if (b!= null){
if (theStudents[studentIndex].booksCount<=3){
System.out.println("adding book");
theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCo
unt] = b;
theStudents[studentIndex].booksCount++;
return;
}
else {
System.out.println("Student Can not Borrow more than 3 Books.");
return;
}
}
System.out.println("Book is not Available.");
}
}
public void checkInBook(books book){
int studentIndex = this.isStudent();
if (studentIndex != -1){
System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
student s = theStudents[studentIndex];
for (int i=0; i<s.booksCount; i++){

System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" +
s.borrowedBooks[i].bookName + "\t\t\t"+
s.borrowedBooks[i].authorName);
}
System.out.println("Enter Serial Number of Book to be Checked In:");
int sNo = input.nextInt();
for (int i=0; i<s.booksCount; i++){
if (sNo == s.borrowedBooks[i].sNo){
book.checkInBook(s.borrowedBooks[i]);
s.borrowedBooks[i]=null;
return;
}
}
System.out.println("Book of Serial No "+sNo+"not Found");
}
}
}
public class Library{
public static void main(String[] args) {
Scanner input = new Scanner(System.in);
System.out.println("*******Welcome to the Student Library!*******");
System.out.println(" Please Select From The Following Options
");
System.out.println("************************");
books ob = new books();
students obStudent = new students();
int choice;
int searchChoice;
do{
ob.dispMenu();
choice = input.nextInt();
switch(choice){
case 1:
book b = new book();
ob.addBook(b);
break;
case 2:
ob.upgradeBookQty();
break;
case 3:
System.out.println("Enter 1 to Search with Serial Number");
System.out.println("Enter 2 to Search with Author Name(Full Name).");
searchChoice = input.nextInt();

switch(searchChoice){
case 1:
ob.searchBySno();
break;
case 2:
ob.searchByAuthorName();
}
break;
case 4:
ob.showAllBooks();
break;
case 5:
student s = new student();
obStudent.addStudent(s);
break;
case 6:
obStudent.showAllStudents();
break;
case 7:
obStudent.checkOutBook(ob);
break;
case 8:
obStudent.checkInBook(ob);
break;
}
}
while (choice!=0);
}
}