package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FileChooser fc = new FileChooser();
			fc.getExtensionFilters().addAll(new ExtensionFilter("Text File", "*txt"));
			File file1 = fc.showOpenDialog(primaryStage);
			
			fc.setTitle("Choose Path for Flight List");
			System.out.println(file1);
			
			FileChooser fc1 = new FileChooser();
			fc1.getExtensionFilters().addAll(new ExtensionFilter("Text File", "*txt"));
			File file2 = fc1.showOpenDialog(primaryStage);
			
			fc1.setTitle("Choose Path for Passenger List");
			System.out.println(file2);
			
			
			
			Button FlightFile = new Button("Browse Flight File");
			FlightFile.setTranslateX(150);
			FlightFile.setTranslateY(620);
			FlightFile.setStyle("-fx-background-color: #212121; -fx-font-size:15; -fx-font-weight:bold");
			FlightFile.setTextFill(Color.WHITE);
			FlightFile.setOnAction(e -> {
				
				FileChooser fc2 = new FileChooser();
				fc2.getExtensionFilters().addAll(new ExtensionFilter("Text File", "*txt"));
				File file3 = fc2.showOpenDialog(primaryStage);
				
				System.out.println(file3);
			
			});

			Button PassengerFile = new Button("Browse Passeneger File");
			PassengerFile.setTranslateX(340);
			PassengerFile.setTranslateY(620);
			PassengerFile.setStyle("-fx-background-color: #212121; -fx-font-size:15; -fx-font-weight:bold");
			PassengerFile.setTextFill(Color.WHITE);
			
			PassengerFile.setOnAction(e -> {
				FileChooser fc4 = new FileChooser();
				
				fc4.getExtensionFilters().addAll(new ExtensionFilter("Text File", "*txt"));
				
				File file4 = fc4.showOpenDialog(primaryStage);
				
				System.out.println(file4);
			});
		
			
			
			File flights = new File(file1.getPath());
			File passengers = new File(file2.getPath());

			BufferedReader flights_br = new BufferedReader(new FileReader(flights));
			BufferedReader passengers_br = new BufferedReader(new FileReader(passengers));

			FlightSystem instance = new FlightSystem();

			String st_flight = "";
			while ((st_flight = flights_br.readLine()) != null) {// READING FROM FILES
				String[] split = st_flight.split(",");
				//for (int i = 0; i < split.length - 4; i++) {
//					instance.addFlight(Integer.parseInt(split[i]), split[i + 1], split[i + 2], split[i + 3],
//							Integer.parseInt(split[i + 4]));
				//}
			}

			try {
				String st_passegners = "";
				while ((st_passegners = passengers_br.readLine()) != null) {// ADDING PASSENGERS BASED ON FLIGHT NUMBER
					String[] split = st_passegners.split(",");
					for (int i = 0; i < split.length - 5; i++) {
						instance.addPassengertoFlight(Integer.parseInt(split[i]), split[i + 1], split[i + 2],
								split[i + 3], split[i + 4], split[i + 5]);
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			flights_br.close();
			passengers_br.close();

			Pane root = new Pane();
			Pane root1 = new Pane();
			Pane root2 = new Pane();

			
			
			Image img1 = new Image("main.jpg", 1280, 720, false, false);
			BackgroundImage bImg = new BackgroundImage(img1, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, // Setting
																														// the
																														// background
																														// for
																														// every
																														// scene
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background bGround = new Background(bImg);
			root.setBackground(bGround);// main screen

			Image img2 = new Image("second.jpg", 1280, 720, false, false);
			BackgroundImage bImg1 = new BackgroundImage(img2, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, // Setting
																														// the
																														// background
																														// for
																														// every
																														// scene
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background bGround1 = new Background(bImg1);
			root1.setBackground(bGround1);// main screen

			Image img3 = new Image("third1.jpg", 1280, 720, false, false);
			BackgroundImage bImg2 = new BackgroundImage(img3, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, // Setting
																														// the
																														// background
																														// for
																														// every
																														// scene
					BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background bGround2 = new Background(bImg2);
			root2.setBackground(bGround2);// main screen

			Button mngFlights = new Button();

			mngFlights.setTranslateX(272);
			mngFlights.setTranslateY(500);

			mngFlights.setText("Flights");
			mngFlights.setStyle("-fx-background-color: #212121; -fx-font-size:23; -fx-font-weight:bold");
			mngFlights.setTextFill(Color.WHITE);

			Button mngPassengers = new Button();

			mngPassengers.setTranslateX(250);
			mngPassengers.setTranslateY(400);
			mngPassengers.setText("Passengers");
			mngPassengers.setStyle("-fx-background-color: #212121; -fx-font-size:23; -fx-font-weight:bold");
			mngPassengers.setTextFill(Color.WHITE);

//			root.getChildren().add(FlightFile);
//			root.getChildren().add(PassengerFile);
			root.getChildren().add(mngFlights);
			root.getChildren().add(mngPassengers);

			Button DisplayFlight = new Button();
			DisplayFlight.setTranslateX(50);
			DisplayFlight.setTranslateY(200);
			DisplayFlight.setText("Display All Flights");
			DisplayFlight.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			DisplayFlight.setTextFill(Color.WHITE);
			root1.getChildren().add(DisplayFlight);
			
			DisplayFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));

					Label text = new Label();

					//text.setStyle("verdana", 12);

					text.setText(instance.getAllFlightsInfo());

					dialogVbox.add(text, 0, 3);

					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);
					Scene dialogScene = new Scene(borderPane, 640, 480);
					dialog.setTitle("Display Flights");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});
			

			Button DisplayPassengers = new Button();
			DisplayPassengers.setTranslateX(50);
			DisplayPassengers.setTranslateY(300);
			DisplayPassengers.setText("Display Passengers for Flight");
			DisplayPassengers.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			DisplayPassengers.setTextFill(Color.WHITE);
			root1.getChildren().add(DisplayPassengers);
			
			DisplayPassengers.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));

					Label text = new Label();
					
					//text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));
					
					Label enterID = new Label("Enter Flight Number (3 Digits) :");

					TextField IDInput = new TextField();
					IDInput.setPrefColumnCount(14);
					
					Button ADDcustomer = new Button("Submit!");
					dialogVbox.add(enterID, 0, 1);
					dialogVbox.add(IDInput, 1, 1);
					dialogVbox.add(ADDcustomer, 1, 2);

					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							text.setText(instance.getAllPassengerInfo(Integer.parseInt(IDInput.getText())));
						}
					});

					dialogVbox.add(text, 0, 3);

					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);
					Scene dialogScene = new Scene(borderPane, 640, 480);
					dialog.setTitle("Search Customer");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});

			Button AddFlight = new Button();
			AddFlight.setTranslateX(50);
			AddFlight.setTranslateY(400);
			AddFlight.setText("Add Flight");
			AddFlight.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			AddFlight.setTextFill(Color.WHITE);
			root1.getChildren().add(AddFlight);

			AddFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));

					Label enterID = new Label("Flight Number:");
					Label enterName = new Label("Airline Name:");
					Label enterAddress = new Label("Source:");
					Label enterMobile = new Label("Destination:");
					Label enterPlan = new Label("Capacity:");

					TextField IDInput = new TextField();
					TextField NameInput = new TextField();
					TextField AddressInput = new TextField();
					TextField MobileInput = new TextField();
					TextField PlanInput = new TextField();

					NameInput.setPrefColumnCount(14);
					IDInput.setPrefColumnCount(14);
					AddressInput.setPrefColumnCount(14);
					MobileInput.setPrefColumnCount(14);
					PlanInput.setPrefColumnCount(14);

					Button ADDcustomer = new Button("Submit!");

					dialogVbox.add(enterID, 0, 1);
					dialogVbox.add(IDInput, 1, 1);
					dialogVbox.add(enterName, 0, 2);
					dialogVbox.add(NameInput, 1, 2);
					dialogVbox.add(enterAddress, 0, 3);
					dialogVbox.add(AddressInput, 1, 3);
					dialogVbox.add(enterMobile, 0, 4);
					dialogVbox.add(MobileInput, 1, 4);
					dialogVbox.add(enterPlan, 0, 5);
					dialogVbox.add(PlanInput, 1, 5);

					dialogVbox.add(ADDcustomer, 1, 6);

					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);

					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							instance.addFlight(Integer.parseInt(IDInput.getText()), NameInput.getText(),
									AddressInput.getText(), MobileInput.getText(),
									Integer.parseInt(PlanInput.getText()));
							 System.out.println(instance.getAllFlightsInfo());
						}
					});
					Scene dialogScene = new Scene(borderPane, 500, 500);
					dialog.setTitle("Add Flight");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});

			Button UpdateFlight = new Button();
			UpdateFlight.setTranslateX(50);
			UpdateFlight.setTranslateY(500);
			UpdateFlight.setText("Update Flight");
			UpdateFlight.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			UpdateFlight.setTextFill(Color.WHITE);
			root1.getChildren().add(UpdateFlight);
			
			UpdateFlight.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));
					Label enterNumber = new Label("Enter Flight Number to Update: ");
					Label enterID = new Label("Flight Number:");
					Label enterName = new Label("Airline Name:");
					Label enterAddress = new Label("Source:");
					Label enterMobile = new Label("Destination:");
					Label enterPlan = new Label("Capacity:");
					
					TextField IDInput = new TextField();
					TextField NameInput = new TextField();
					TextField AddressInput = new TextField();
					TextField MobileInput = new TextField();
					TextField PlanInput = new TextField();
					TextField NumberInput = new TextField();

					NumberInput.setPrefColumnCount(14);
					NameInput.setPrefColumnCount(14);
					IDInput.setPrefColumnCount(14);
					AddressInput.setPrefColumnCount(14);
					MobileInput.setPrefColumnCount(14);
					PlanInput.setPrefColumnCount(14);
					dialogVbox.add(enterNumber, 0, 1);
					dialogVbox.add(NumberInput, 1, 1);
					Button showFlight = new Button("Search");
					Text show = new Text();
					showFlight.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							show.setText(instance.getAllFlightInfo(Integer.parseInt(NumberInput.getText())));
						}
					});
					dialogVbox.add(showFlight, 0, 2);
					dialogVbox.add(show, 1, 2);

					
					Button ADDcustomer = new Button("Update!");
					
					dialogVbox.add(enterID, 0, 3);
					dialogVbox.add(IDInput, 1, 3);
					dialogVbox.add(enterName, 0, 4);
					dialogVbox.add(NameInput, 1, 4);
					dialogVbox.add(enterAddress, 0, 5);
					dialogVbox.add(AddressInput, 1, 5);
					dialogVbox.add(enterMobile, 0, 6);
					dialogVbox.add(MobileInput, 1, 6);
					dialogVbox.add(enterPlan, 0, 7);
					dialogVbox.add(PlanInput, 1, 7);

					dialogVbox.add(ADDcustomer, 1, 8);

					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);

					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							instance.deleteFlight(Integer.parseInt(NumberInput.getText()));
							
							instance.addFlight(Integer.parseInt(IDInput.getText()), NameInput.getText(),
									AddressInput.getText(), MobileInput.getText(),
									Integer.parseInt(PlanInput.getText()));
						
							System.out.println(instance.getAllFlightsInfo());
						
						}
					});
					Scene dialogScene = new Scene(borderPane, 500, 500);
					dialog.setTitle("Add Flight");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});
			

			Button back_1 = new Button();
			back_1.setTranslateX(50);
			back_1.setTranslateY(600);
			back_1.setText("Back");
			back_1.setStyle("-fx-background-color: #212121; -fx-font-size:23; -fx-font-weight:bold");
			back_1.setTextFill(Color.WHITE);
			root1.getChildren().add(back_1);// back button for the flights page

			Button Reserve = new Button();
			Reserve.setTranslateX(50);
			Reserve.setTranslateY(200);
			Reserve.setText("Reserve Ticket");
			Reserve.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			Reserve.setTextFill(Color.WHITE);
			root2.getChildren().add(Reserve);
			
			Reserve.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));

					Label enterID = new Label("Flight Number:");
					Label enterName = new Label("Ticket Number:");
					Label enterAddress = new Label("Full Name:");
					Label enterMobile = new Label("Passport:");
					Label enterPlan = new Label("Nationality:");
					Label enterDate = new Label("Birth Date:");

					TextField IDInput = new TextField();
					TextField NameInput = new TextField();
					TextField AddressInput = new TextField();
					TextField MobileInput = new TextField();
					TextField PlanInput = new TextField();
					TextField DateInput = new TextField();

					NameInput.setPrefColumnCount(14);
					IDInput.setPrefColumnCount(14);
					AddressInput.setPrefColumnCount(14);
					MobileInput.setPrefColumnCount(14);
					PlanInput.setPrefColumnCount(14);
					DateInput.setPrefColumnCount(14);
					
					Button ADDcustomer = new Button("Submit!");

					dialogVbox.add(enterID, 0, 1);
					dialogVbox.add(IDInput, 1, 1);
					dialogVbox.add(enterName, 0, 2);
					dialogVbox.add(NameInput, 1, 2);
					dialogVbox.add(enterAddress, 0, 3);
					dialogVbox.add(AddressInput, 1, 3);
					dialogVbox.add(enterMobile, 0, 4);
					dialogVbox.add(MobileInput, 1, 4);
					dialogVbox.add(enterPlan, 0, 5);
					dialogVbox.add(PlanInput, 1, 5);
					dialogVbox.add(enterDate, 0, 6);
					dialogVbox.add(DateInput, 1, 6);

					dialogVbox.add(ADDcustomer, 1, 7);

					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);

					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							instance.addPassengertoFlight(Integer.parseInt(IDInput.getText()), NameInput.getText(),
									AddressInput.getText(), MobileInput.getText(),
									PlanInput.getText(), DateInput.getText());
							 System.out.println(instance.getAllPassengerInfo(Integer.parseInt(IDInput.getText())));
						}
					});
					Scene dialogScene = new Scene(borderPane, 500, 500);
					dialog.setTitle("Add Passenger");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});
			
			

			Button Cancel = new Button();
			Cancel.setTranslateX(50);
			Cancel.setTranslateY(300);
			Cancel.setText("Cancel Reservation");
			Cancel.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			Cancel.setTextFill(Color.WHITE);
			root2.getChildren().add(Cancel);
			
			Cancel.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));

					//Label text = new Label();

					//text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

					Label enterID = new Label("Enter Flight Number (3 Digits) :");
					Label enterTicket = new Label("Enter Ticket Number (8 Digits) :");

					TextField IDInput = new TextField();
					TextField TicketInput = new TextField();
					IDInput.setPrefColumnCount(14);
					TicketInput.setPrefColumnCount(14);
					
					Button ADDcustomer = new Button("Submit!");
					
					dialogVbox.add(enterID, 0, 1);
					dialogVbox.add(IDInput, 1, 1);
					dialogVbox.add(enterTicket, 0, 2);
					dialogVbox.add(TicketInput, 1, 2);
					dialogVbox.add(ADDcustomer, 1, 3);

					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							instance.cancelReserve(Integer.parseInt(IDInput.getText()), TicketInput.getText());
							System.out.println(instance.getAllPassengerInfo(Integer.parseInt(IDInput.getText())));
						}
					});


					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);
					Scene dialogScene = new Scene(borderPane, 640, 480);
					dialog.setTitle("Search Customer");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});

			Button SearchPassenger = new Button();
			SearchPassenger.setTranslateX(50);
			SearchPassenger.setTranslateY(400);
			SearchPassenger.setText("Search Passenger");
			SearchPassenger.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			SearchPassenger.setTextFill(Color.WHITE);
			root2.getChildren().add(SearchPassenger);
			
			SearchPassenger.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));


					//text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

					Label enterID = new Label("Enter Flight Number (3 Digits) :");
					Label enterTicket = new Label("Enter Ticket Number (8 Digits) :");

					TextField IDInput = new TextField();
					TextField TicketInput = new TextField();
					IDInput.setPrefColumnCount(14);
					TicketInput.setPrefColumnCount(14);
					
					Button ADDcustomer = new Button("Submit!");
					 
					dialogVbox.add(enterID, 0, 1);
					dialogVbox.add(IDInput, 1, 1);
					dialogVbox.add(enterTicket, 0, 2);
					dialogVbox.add(TicketInput, 1, 2);
					dialogVbox.add(ADDcustomer, 1, 3);
					Text text = new Text();
					
					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							text.setText(instance.searchPassenger(Integer.parseInt(IDInput.getText()), TicketInput.getText()));						
							
							System.out.println(instance.getAllPassengerInfo(Integer.parseInt(IDInput.getText())));
						}
					});
					dialogVbox.add(text, 1, 4);


					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);
					Scene dialogScene = new Scene(borderPane, 640, 480);
					dialog.setTitle("Search Customer");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});

			Button CheckReserve = new Button();
			CheckReserve.setTranslateX(50);
			CheckReserve.setTranslateY(500);
			CheckReserve.setText("Check Reservation");
			
			CheckReserve.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					final Stage dialog = new Stage();
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);

					GridPane dialogVbox = new GridPane();
					dialogVbox.setAlignment(Pos.CENTER);
					dialogVbox.setHgap(5);
					dialogVbox.setVgap(5);
					dialogVbox.setPadding(new Insets(25, 25, 25, 25));


					//text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12));

					Label enterID = new Label("Enter Flight Number (3 Digits) :");
					Label enterTicket = new Label("Enter Ticket Number (8 Digits) :");

					TextField IDInput = new TextField();
					TextField TicketInput = new TextField();
					IDInput.setPrefColumnCount(14);
					TicketInput.setPrefColumnCount(14);
					
					Button ADDcustomer = new Button("Submit!");
					
					dialogVbox.add(enterID, 0, 1);
					dialogVbox.add(IDInput, 1, 1);
					dialogVbox.add(enterTicket, 0, 2);
					dialogVbox.add(TicketInput, 1, 2);
					dialogVbox.add(ADDcustomer, 1, 3);
					TextField text = new TextField();
					text.setDisable(true);
					
					ADDcustomer.setOnAction(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent arg0) {
							if(instance.checkReserve(Integer.parseInt(IDInput.getText()), TicketInput.getText())) {
								text.setText("Reservation found :)");
							}else {
								text.setText("Reservation NOT found :(");
							}
							
							System.out.println(instance.getAllPassengerInfo(Integer.parseInt(IDInput.getText())));
						}
					});
					dialogVbox.add(text, 1, 4);


					BorderPane borderPane = new BorderPane();
					borderPane.setCenter(dialogVbox);
					Scene dialogScene = new Scene(borderPane, 640, 480);
					dialog.setTitle("Search Customer");
					dialog.setScene(dialogScene);
					dialog.show();
				}
			});

			CheckReserve.setStyle("-fx-background-color: #212121; -fx-font-size:21");
			CheckReserve.setTextFill(Color.WHITE);
			root2.getChildren().add(CheckReserve);

			Button back_2 = new Button();
			back_2.setTranslateX(50);
			back_2.setTranslateY(600);
			back_2.setText("Back");
			back_2.setStyle("-fx-background-color: #212121; -fx-font-size:23; -fx-font-weight:bold");
			back_2.setTextFill(Color.WHITE);
			root2.getChildren().add(back_2);// back button for the passengers page

			Scene FlightScene = new Scene(root1, 1280, 720);

			Scene PassengerScene = new Scene(root2, 1280, 720);

			Scene scene = new Scene(root, 1280, 720);

			mngFlights.setOnAction(e -> primaryStage.setScene(FlightScene));

			mngPassengers.setOnAction(e -> primaryStage.setScene(PassengerScene));

			back_1.setOnAction(e -> primaryStage.setScene(scene));

			back_2.setOnAction(e -> primaryStage.setScene(scene));

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Linked Airways - Beta");

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
