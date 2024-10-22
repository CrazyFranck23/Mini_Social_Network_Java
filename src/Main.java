public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);

        // Création d'utilisateurs
        User user1 = new User(1, "Crazy", "crazy@gmail.com");
        User user2 = new User(2, "Alionka", "alionka@outlook.com");

        // Enregistrement des utilisateurs dans la base de données
        userService.registerUser(user1);
        userService.registerUser(user2);

        // Récupérer un utilisateur de la base de données
        User foundUser = userService.getUser(1);
        System.out.println("Utilisateur trouvé : " + foundUser);

    }
}
