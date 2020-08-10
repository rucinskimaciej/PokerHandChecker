package online.rumac.main.controller.figure.figureDefinition;

import online.rumac.main.controller.figure.PokerFigure;
import online.rumac.main.model.hand.PokerHand;

public abstract class Figure {

    protected Figure() {}

    public abstract PokerFigure check(PokerHand hand);


}
