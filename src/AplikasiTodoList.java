import java.util.Scanner;

public class AplikasiTodoList {

  public static String[] model = new String[10];
  public static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    //    testShowTodoList();
    //    testAddTodoList();
    //    testRemoveTodoList();
    //    testInputData();
    //    testViewShowTodoList();
    //    testViewAddTodoList();
    testViewRemoveTodoList();
  }

  /** Menampilkan todo list */
  public static void showTodoList() {
    System.out.println("TODOLIST");
    for (var i = 0; i < model.length; i++) {
      var todo = model[i];
      var no = i + 1;

      if (todo != null) {
        System.out.println(no + ". " + todo);
      }
    }
  }

  /** Test Menampilkan todo list */
  public static void testShowTodoList() {
    model[0] = "Pray";
    model[1] = "Read Book";
    model[2] = "Work";
    model[3] = "Eat";
    model[4] = "Pray";
    model[5] = "Work";
    showTodoList();
  }

  /** Menambahkan todo list */
  public static void addTodoList(String todo) {
    // Check apakah model penuh?
    var isFull = true;
    for (int i = 0; i < model.length; i++) {
      if (model[i] == null) {
        // kalau datanya masih ada yang kosong
        isFull = false;
        break;
      }
    }

    // Jika penuh, rieze ukuran array 2x lipat
    if (isFull) {
      var temp = model;
      model = new String[model.length * 2];

      for (int i = 0; i < temp.length; i++) {
        model[i] = temp[i];
      }
    }

    // Tambahkan ke posisi yang data array nya Null
    for (var i = 0; i < model.length; i++) {
      if (model[i] == null) {
        model[i] = todo;
        break;
      }
    }
  }

  /** Test menambahkan todo list */
  public static void testAddTodoList() {
    for (int i = 0; i < 25; i++) {
      addTodoList("Sample Todo -" + i);
    }
    showTodoList();
  }

  /** Menghapus todo list */
  public static boolean removeTodoList(Integer number) {
    if (model.length <= (number - 1)) {
      return false;
    } else if (model[number - 1] == null) {
      return false;
    } else {
      for (int i = (number - 1); i < model.length; i++) {
        if (i == (model.length - 1)) {
          model[i] = null;
        } else {
          model[i] = model[i + 1];
        }
      }
      return true;
    }
  }

  /** Test menghapus todo list */
  public static void testRemoveTodoList() {
    addTodoList("Satu");
    addTodoList("Duna");
    addTodoList("Tiga");
    addTodoList("Empat");
    addTodoList("Lima");

    var result = removeTodoList(20);
    System.out.println(result);

    result = removeTodoList(7);
    System.out.println(result);

    result = removeTodoList(2);
    System.out.println(result);

    showTodoList();
  }

  /** Input data dari user */
  public static String input(String info) {
    System.out.print(info + " : ");
    String data = scanner.nextLine();
    return data;
  }

  /** test input data */
  public static void testInputData() {
    var data = input("Nama");
    System.out.println("Hi " + data);

    var channel = input("Channel");
    System.out.println(channel);
  }

  /** Menampilkan view todo list */
  public static void viewShowTodoList() {
    while (true) {
      showTodoList();
      System.out.println("Menu");
      System.out.println("1. Tambah");
      System.out.println("2. Hapus");
      System.out.println("x. Keluar");

      var input = input("Pilih");
      if (input.equals("1")) {
        viewAddTodoList();
      } else if (input.equals("2")) {
        viewRemoveTodoList();
      } else if (input.equals("x")) {
        break;
      } else {
        System.out.println("Pilihan tidak dimengerti");
      }
    }
  }

  /** Test view viewShowTodoList */
  public static void testViewShowTodoList() {
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");
    addTodoList("Empat");
    addTodoList("Lima");
    viewShowTodoList();
  }

  /** Menampilkan view menambahkan todo list */
  public static void viewAddTodoList() {
    System.out.println("MENAMBAH TODOLIST");
    var todo = input("Todo (x Jika Batal)");

    if (todo.equals("x")) {
      // batal
    } else {
      addTodoList(todo);
    }
  }

  /** Test View Menambah TodoList */
  public static void testViewAddTodoList() {
    addTodoList("Satu");
    addTodoList("Dua");

    viewAddTodoList();

    showTodoList();
  }

  /** Menampilkan view menghapus todo list */
  public static void viewRemoveTodoList() {
    System.out.println("MENGHAPUS TODOLIST");

    var number = input("Nomor yang dihapus (x Jika Batal)");

    if (number.equals("x")) {
      // batal
    } else {
      boolean success = removeTodoList(Integer.valueOf(number));
      if (!success) {
        System.out.println("Gagal menghapus todolist : " + number);
      }
    }
  }

  /** test View Remove TodoList */
  public static void testViewRemoveTodoList() {
    addTodoList("Satu");
    addTodoList("Dua");
    addTodoList("Tiga");

    showTodoList();

    viewRemoveTodoList();

    showTodoList();
  }
}
