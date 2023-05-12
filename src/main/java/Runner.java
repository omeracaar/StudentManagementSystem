import java.util.Scanner;

/*
Proje:Student Management System
     -1-Herhangi bir eğitim kurumu için öğrenci yönetim uygulaması geliştiriniz.
     -2-Kullanıcı
               -öğrenci kayıt
               -öğrenci veya öğrencileri görüntüleme
               -id ile öğrenci güncelleme
               -id ile öğrenci silme
       işlemlerini yapabilmeli.
     -3-öğrenci:id,name,lastname,city,age özelliklerine sahiptir.


     ODEV:ogrenci silme isleminden sonra silinen ogrencinin bilgilerini goster
     ODEV:ogrenci ekleme isleminden sonra eklenen ogrencinin bilgilerini goster
     ODEV: -R:ad-soyadi ile ogrenci filtreleme islemlerini yapalim.
 */
public class Runner {
    public static void main(String[] args) {
        start();
    }
    //1-ADIM:kullanıcıya menü gösterelim
    //2-student classını oluşturma
    public static void start(){

        Scanner inp=new Scanner(System.in);
        //10-service ve tablo oluşturma
        StudentService service=new StudentService();
        service.createStudentTable();

        int select;
        int id;
        do {
            System.out.println("=====================================");
            System.out.println("Öğrenci Yönetim Paneli");
            System.out.println("1-Öğrenci Kayıt");
            System.out.println("2-Tüm Öğrencileri Listele");
            System.out.println("3-Öğrenci Güncelle");
            System.out.println("4-Öğrenci Sil");
            System.out.println("5-Ogreniyi gosterme");
            System.out.println("0-ÇIKIŞ");
            System.out.println("İşlem Seçiniz: ");
            select=inp.nextInt();
            inp.nextLine();
            switch (select){
                case 1:
                    //11-Öğrenci Kayıt
                    service.saveStudent();
                    service.getAllStudent();
                    break;
                case 2:
                    service.getAllStudent();
                    //13-Tüm Öğrencileri Listele
                    break;
                case 3:
                    //16-tablodan idsi verilen kaydi silme
                    //  System.out.println("Öğrenci Id: ");
                    id=getId(inp);
                    //Öğrenci Güncelle
                    service.updateStudent(id);

                    break;
                case 4:
                    id=getId(inp);
                    //15-öğrenci silme
                    service.deleteStudent(id);
                    service.getAllStudent();
                    break;
                case 5:
                id=getId(inp);
                //21-ogrenciyi bulma
                service.displayStudent(id);
                    break;
                case 0:
                    System.out.println("İyi günler...");
                    break;
                default:
                    System.out.println("Hatalı giriş!!!");
                    break;
            }

        }while(select!=0);

    }

    private static int getId(Scanner inp){
        System.out.println("Öğrenci Id: ");
        int id=inp.nextInt();
        inp.nextLine();
        return id;

    }

}

