public class AplikasiTodolist {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    /**
     * Menampilkan todo list
     */
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

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi kasus: Aplikasi Todolist";
        showTodoList();
    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodoList(String todo) {
        // melakukan pengecekan apakah model masih kosong / penuh
        var isFull = true;
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        // resize model jika penuh
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];
            for (var i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // memasukan todo ke dalam list
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }
    }

    public static void testAddTodoList() {
        for (var i = 0; i < 25; i++) {
            addTodoList("Todo ke-" + i);
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        if ((number - 1) >= model.length) {
            return false;
        } else if (model[number - 1] == null) {
            return  false;
        } else {
            for (var i = (number - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodolist() {
        addTodoList("Belajar Java Dasar");
        addTodoList("Belajar Golang");
        addTodoList("Belajar PHP");

        var result = removeTodoList(4);
        System.out.println(result);

        showTodoList();

        result = removeTodoList(2);
        System.out.println(result);

        showTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Masukkan nama anda");
        System.out.println("Hi " + name);

        var address = input("Masukkan alamat anda");
        System.out.println(address);
    }

    /**
     * Menampilkan view show todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Masukan pilihan");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilihan tidak dimengerti");
            }
        }
    }

    public static void testViewShowTodolist() {
        addTodoList("Belajar Java");
        addTodoList("Belajar Golang");
        addTodoList("Belajar Rust");
        viewShowTodoList();
    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList() {
        System.out.println("Menambahkan todolist");

        var todo = input("Todo (masukkan x untuk membatalkan)");

        if (todo.equals("x")) {
            // batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodolist() {
        addTodoList("Bejo");
        addTodoList("Ramli");

        viewAddTodoList();

        showTodoList();
    }

    /**
     * Menampilkan view menghapus todo dari list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODOLIST");

        var number = input("Masukan nomor todo yang akan dihapus (masukan x jika ingin membatalkan)");

        if (number.equals("x")) {
            //batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todolist no " + number);
            }
        }
    }

    public static void testViewRemoveTodolist() {
        addTodoList("Java");
        addTodoList("Golang");
        addTodoList("Rust");

        showTodoList();

        viewRemoveTodoList();

        showTodoList();
    }

}
