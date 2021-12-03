public class AplikasiTodoList {

  public static String[] model = new String[10];

  public static void main(String[] args) {
    testShowTodoList();
  }

  /**
   * Menampilkan todo list
   */
  public static void showTodoList() {
    for (var i = 0; i < model.length; i++) {
      var todo = model[i];
      var no = i + 1;

      if (todo != null) {
        System.out.println(no + ". " + todo);
      }
    }
  }

  /**
   * Test Menampilkan todo list
   */
  public static void testShowTodoList() {
    model[0] = "Pray";
    model[1] = "Read Book";
    model[2] = "Work";
    model[3] = "Eat";
    model[4] = "Pray";
    model[5] = "Work";
    showTodoList();
  }

  /**
   * Menambahkan todo list 
   */
  public static void addTodoList() {

  }

  /**
   * Menghapus todo list
   */
  public static void removeTodoList() {
    
  }

  /**
   * Menampilkan view todo list
   */
  public static void viewShowTodoList() {

  }

  /**
   * Menampilkan view menambahkan todo list
   */
  public static void viewAddTodoList() {

  }

  /**
   * Menampilkan view menghapus todo list
   */
  public static void viewRemoveTodoList() {
    
  }
}
