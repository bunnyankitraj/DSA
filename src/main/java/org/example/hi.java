package org.example;

// The abstract factory interface declares a set of methods that
// return different abstract products. These products are called
// a family and are related by a high-level theme or concept.
// Products of one family are usually able to collaborate among
// themselves. A family of products may have several variants,
// but the products of one variant are incompatible with the
// products of another variant.
interface GUIFactory {
    Buttons createButton();
    Checkbox createCheckbox();
}

// Concrete factories produce a family of products that belong
// to a single variant. The factory guarantees that the
// resulting products are compatible. Signatures of the concrete
// factory's methods return an abstract product, while inside
// the method a concrete product is instantiated.
class WinFactory implements GUIFactory {
    @Override
    public Buttons createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WinCheckbox();
    }
}

// Each concrete factory has a corresponding product variant.
class MacFactory implements GUIFactory {
    @Override
    public Buttons createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Each distinct product of a product family should have a base
// interface. All variants of the product must implement this
// interface.
interface Buttons {
    void paint();
}

// Concrete products are created by corresponding concrete
// factories.
class WinButton implements Buttons {
    @Override
    public void paint() {
        // Render a button in Windows style.
        System.out.println("Rendering Windows style button.");
    }
}

class MacButton implements Buttons {
    @Override
    public void paint() {
        // Render a button in macOS style.
        System.out.println("Rendering macOS style button.");
    }
}

// Here's the base interface of another product. All products
// can interact with each other, but proper interaction is
// possible only between products of the same concrete variant.
interface Checkbox {
    void paint();
}

class WinCheckbox implements Checkbox {
    @Override
    public void paint() {
        // Render a checkbox in Windows style.
        System.out.println("Rendering Windows style checkbox.");
    }
}

class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        // Render a checkbox in macOS style.
        System.out.println("Rendering macOS style checkbox.");
    }
}

// The client code works with factories and products only
// through abstract types: GUIFactory, Button and Checkbox. This
// lets you pass any factory or product subclass to the client
// code without breaking it.
class ApplicationAbstract {
    private GUIFactory factory;
    private Buttons button;

    public ApplicationAbstract(GUIFactory factory) {
        this.factory = factory;
    }

    public void createUI() {
        this.button = factory.createButton();
    }

    public void paint() {
        button.paint();
    }
}

// The application picks the factory type depending on the
// current configuration or environment settings and creates it
// at runtime (usually at the initialization stage).
class AbstractDP {
    public static void main(String[] args) {
        String configOS = "Windows"; // This would usually be read from a config file.

        GUIFactory factory;
        if (configOS.equals("Windows")) {
            factory = new WinFactory();
        } else if (configOS.equals("Mac")) {
            factory = new MacFactory();
        } else {
            throw new IllegalArgumentException("Error! Unknown operating system.");
        }

        ApplicationAbstract app = new ApplicationAbstract(factory);
        app.createUI();
        app.paint();
    }
}
