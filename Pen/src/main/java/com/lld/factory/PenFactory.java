package com.lld.factory;

import com.lld.enums.PenType;
import com.lld.enums.Color;
import com.lld.interfaces.Pen;
import com.lld.models.BallPointPen;
import com.lld.models.FountainPen;
import com.lld.models.GelPen;

public class PenFactory {

    public static Pen getPen(PenType type, Color color, boolean withCap) {
        switch (type) {
            case BALL_POINT:
                return new BallPointPen(color, withCap);
            case FOUNTAIN:
                return new FountainPen(color, withCap);
            case GEL_PEN:
                return new GelPen(color, withCap);
            default:
                throw new IllegalArgumentException("Unknown Pen Type");
        }
    }
}