package scene;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import scene.component.Header;
import util.Constant;

public class TutorialScene extends AnchorPane {
	public TutorialScene() {
		String tutorialImagePath = ClassLoader.getSystemResource("image/tutorial.png").toString();
		Image tutorialImage = new Image(tutorialImagePath);
		ImageView tutorialImageView = new ImageView(tutorialImage);
		tutorialImageView.setFitWidth(Constant.GAME_WIDTH);

		ScrollPane tutorialPane = new ScrollPane();
		tutorialPane.setPrefSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
		tutorialPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
		tutorialPane.setContent(tutorialImageView);
		getChildren().addAll(tutorialPane, new Header("Tutorial"));
	}
}
