package za.ac.cput.factory;

import za.ac.cput.domain.TutorPreferences;
import za.ac.cput.util.Helper;

public class TutorPreferencesFactory {
    public static TutorPreferences buildTutorPreferences(Long id,boolean canTravel,boolean onlineSession,boolean faceTofaceSession,boolean providesProjectHelp,double minFee,double maxFee) {
        if(id<=0|| Helper.isValidPrice(minFee)||Helper.isValidPrice(maxFee)||minFee>maxFee){
            return null;

        }
        return new TutorPreferences.TutorPreferencesBuilder()
                .setCanTravel(canTravel)
                .setId(id)
                .setFaceTofaceSession(faceTofaceSession)
                .setOnlineSession(onlineSession)
                .setProvidesProjectHelp(providesProjectHelp)
                .setMinFee(minFee)
                .setMaxFee(maxFee)
                .build();

    }

    public static TutorPreferences buildTutorPreferences(boolean canTravel,boolean onlineSession,boolean faceTofaceSession,boolean providesProjectHelp,double minFee,double maxFee) {
        if(Helper.isValidPrice(minFee)||Helper.isValidPrice(maxFee)||minFee>maxFee){
            return null;

        }
        return new TutorPreferences.TutorPreferencesBuilder()
                .setCanTravel(canTravel)
                .setFaceTofaceSession(faceTofaceSession)
                .setOnlineSession(onlineSession)
                .setProvidesProjectHelp(providesProjectHelp)
                .setMinFee(minFee)
                .setMaxFee(maxFee)
                .build();

    }
}
