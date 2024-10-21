public class UserService {
    // Cette classe représente le service métier qui utilise le repository pour gérer les utilisateurs.

    private UserRepository userRepository;

    // Constructeur injectant le UserRepository
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Méthode pour enregistrer un utilisateur
    public void registerUser(User user) {
        userRepository.save(user);
        System.out.println("User registered: " + user);
    }

    // Méthode pour récupérer un utilisateur
    public User getUser(int userId) {
        return userRepository.find(userId);
    }
}
