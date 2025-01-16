import java.util.List;
import java.util.Optional;

public class UserProfile {
    private final String userName;
    private final String email;
    private final Optional<String> phoneNumber;
    private Optional<String> address;

    public UserProfile(String userName, String email, Optional<String> phoneNumber, Optional<String> address) {
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public void printUserProfile(UserProfile user) {
        System.out.println("Username -> " + user.getUserName() + " / email -> " + user.getEmail());
        System.out.println("Phone number -> " + user.getPhoneNumber().orElse("null") + " / address -> " + user.getAddress().orElse("null"));
    }

    public String getPhoneNumber(UserProfile user) {
        return user.getPhoneNumber().orElse("No phone number available");
    }

    public List<UserProfile> filterUsersWithAddress(List<UserProfile> users) {
        return users.stream().filter(userProfile -> userProfile.getPhoneNumber().isPresent()).toList();
    }

    public void updateAddress(UserProfile user, String newAddress) {
        user.getAddress().ifPresentOrElse(s -> System.out.println("Address was not updated!"), () -> {
            user.setAddress(Optional.ofNullable(newAddress));
            System.out.println("Address was updated!");
        });
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Optional<String> getPhoneNumber() {
        return phoneNumber;
    }

    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }
}
