package com.sybetech.presentation;

import com.sybetech.business.TicTacToeGame;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlPanelGrid;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
public class TicTacToeGameUiController
        implements Serializable {

    /****************************************************************************************
     * R7: create a web UI to input x, y and call play. The played moves should be tracked
     ****************************************************************************************/

    private TicTacToeGame game;
    private String gameResult;

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    @PostConstruct
    private void init() {
        game = new TicTacToeGame();
    }

    public void play(ActionEvent event) {
        try {
            String buttonId = event.getComponent().getId().replace("btn", "");
            String[] xy = buttonId.split("_");
            gameResult = game.play(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]));
            String lastPlayer = game.getNextPlayer() + "";
            setButtonValue(event.getComponent(), lastPlayer, false);
            if (!gameResult.equals(TicTacToeGame.RESULT_IN_PROGRESS)) {
                addMessage(gameResult);
                reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    	public String reset() {
		init();
		UIComponent pgComp = FacesContext.getCurrentInstance().getViewRoot().findComponent("f:btnsParent");
		HtmlPanelGrid pg = (HtmlPanelGrid)pgComp;
		for (UIComponent btn : pg.getChildren()) {
			if(btn.getId().startsWith("btn")) {
				setButtonValue(btn, "", false);
			}
		}
		return "index";
	}

    private void setButtonValue(UIComponent component, String val, boolean disabled) {
        HtmlCommandButton cb = (HtmlCommandButton) component;
        cb.setValue(val);
        cb.setDisabled(true);
    }

    private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
