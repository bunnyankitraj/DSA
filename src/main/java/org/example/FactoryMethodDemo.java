package org.example;

// The Creator class declares the factory method that must
// return an object of a Product class. The Creator's subclasses
// usually provide the implementation of this method.
abstract class Dialog {

    // The factory method to be implemented by subclasses.
    abstract Button createButton();

    // Note that, despite its name, the Creator's primary
    // responsibility isn't creating products. It usually
    // contains some core business logic that relies on product
    // objects returned by the factory method. Subclasses can
    // indirectly change that business logic by overriding the
    // factory method and returning a different type of product
    // from it.
    public void render() {
        // Call the factory method to create a product object.
        Button okButton = createButton();
        // Now use the product.
        okButton.onClick(this::closeDialog);
        okButton.render();
    }

    // Example of core business logic
    private void closeDialog() {
        System.out.println("Dialog closed.");
    }
}

// Concrete Creators override the factory method to change the
// resulting product's type.
class WindowsDialog extends Dialog {

    @Override
    Button createButton() {
        return new WindowsButton();
    }
}

class WebDialog extends Dialog {

    @Override
    Button createButton() {
        return new HTMLButton();
    }
}

// The Product interface declares the operations that all
// concrete products must implement.
interface Button {
    void render();
    void onClick(Runnable f);
}

// Concrete Products provide various implementations of the
// Product interface.
class WindowsButton implements Button {

    @Override
    public void render() {
        // Render a button in Windows style.
        System.out.println("Render a Windows button.");
    }

    @Override
    public void onClick(Runnable f) {
        // Bind a native OS click event.
        f.run();
    }
}

class HTMLButton implements Button {

    @Override
    public void render() {
        // Return an HTML representation of a button.
        System.out.println("Render an HTML button.");
    }

    @Override
    public void onClick(Runnable f) {
        // Bind a web browser click event.
        f.run();
    }
}

// The Application class is responsible for initializing the
// correct Dialog depending on the environment.
class Application {

    private Dialog dialog;

    // The application picks a creator's type depending on the
    // current configuration or environment settings.
    void initialize() {
        // Mock configuration (In a real scenario, you'd read this from a file or environment variable)
        String configOS = System.getProperty("os.name").toLowerCase();

        if (configOS.contains("win")) {
            dialog = new WindowsDialog();
        } else if (configOS.contains("web")) {
            dialog = new WebDialog();
        } else {
            throw new RuntimeException("Error! Unknown operating system.");
        }
    }

    // The client code works with an instance of a concrete
    // creator, albeit through its base interface. As long as
    // the client keeps working with the creator via the base
    // interface, you can pass it any creator's subclass.
    void main() {
        this.initialize();
        dialog.render();
    }
}

// Client code
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Application app = new Application();
        app.main();
    }
}
