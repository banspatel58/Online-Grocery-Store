JFLAGS = -g
JC = javac
#PORT = in-csci-rrpc01 3938
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java
	
CLASSES = \
	Controller/StoreServerInterface.java \
	Client/AbstractCommandFactory.java \
	Client/AdminCommandFactory.java \
	Client/CustomerCommandFactory.java \
	Client/FactoryProducer.java \
	Client/Dispatcher.java \
	Client/AdminDashboardView.java \
	Client/AdminRegistrationView.java \
	Client/CustomerDashboardView.java \
	Client/CustomerRegistrationView.java \
	Client/LoginView.java \
	Client/UpdateInventoryView.java \
	Controller/Command.java \
	Server/DatabaseConnection.java \
	Server/DatabaseResult.java \
	Server/User.java \
	Server/Product.java \
	Server/Server.java \
	Server/RemoteDatabaseLookup.java \
	Controller/AddToCartCommand.java \
	Controller/AdminDashboardController.java \
	Controller/AdminRegistrationController.java \
	Controller/AdminRegisterCommand.java \
	Controller/CustomerDashboardController.java \
	Controller/CustomerRegistrationController.java \
	Controller/CustomerRegisterCommand.java \
	Controller/InventoryCommand.java \
	Controller/LoginController.java \
	Controller/LoginCommand.java \
	Controller/UpdateInventoryController.java \
	Controller/UpdateInventoryCommand.java \
	Client/Client.java \
	
default: classes

classes: $(CLASSES:.java=.class)

Server: default
	java Server/Server $(serverName) $(portNumber)

Client: default
	java Client/Client $(serverName) $(portNumber)

clean:
	rm Client/*.class
	rm Server/*.class
	rm Controller/*.class
	