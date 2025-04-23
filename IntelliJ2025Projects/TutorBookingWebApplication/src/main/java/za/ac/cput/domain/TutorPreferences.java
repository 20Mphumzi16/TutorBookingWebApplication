package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class TutorPreferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean canTravel;
    private boolean onlineSession;
    private boolean faceTofaceSession;
    private boolean providesProjectHelp;
    private double minFee;
    private double maxFee;

    public TutorPreferences() {
    }

    private TutorPreferences(TutorPreferencesBuilder builder) {
        this.id = builder.id;
        this.canTravel = builder.canTravel;
        this.onlineSession = builder.onlineSession;
        this.faceTofaceSession = builder.faceTofaceSession;
        this.providesProjectHelp = builder.providesProjectHelp;
        this.minFee = builder.minFee;
        this.maxFee = builder.maxFee;
    }

    public boolean isProvidesProjectHelp() {
        return providesProjectHelp;
    }

    public Long getId() {
        return id;
    }

    public boolean isCanTravel() {
        return canTravel;
    }

    public boolean isOnlineSession() {
        return onlineSession;
    }

    public boolean isFaceTofaceSession() {
        return faceTofaceSession;
    }

    public double getMinFee() {
        return minFee;
    }

    public double getMaxFee() {
        return maxFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TutorPreferences that = (TutorPreferences) o;
        return canTravel == that.canTravel && onlineSession == that.onlineSession && faceTofaceSession == that.faceTofaceSession && providesProjectHelp == that.providesProjectHelp && Double.compare(minFee, that.minFee) == 0 && Double.compare(maxFee, that.maxFee) == 0 && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, canTravel, onlineSession, faceTofaceSession, providesProjectHelp, minFee, maxFee);
    }

    @Override
    public String toString() {
        return "TutorPreferences{" +
                "id=" + id +
                ", canTravel=" + canTravel +
                ", onlineSession=" + onlineSession +
                ", faceTofaceSession=" + faceTofaceSession +
                ", providesProjectHelp=" + providesProjectHelp +
                ", minFee=" + minFee +
                ", maxFee=" + maxFee +
                '}';
    }

    public static class TutorPreferencesBuilder {
        private Long id;
        private boolean canTravel;
        private boolean onlineSession;
        private boolean faceTofaceSession;
        private boolean providesProjectHelp;
        private double minFee;
        private double maxFee;

        public TutorPreferencesBuilder() {
        }

        public TutorPreferencesBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public TutorPreferencesBuilder setCanTravel(boolean canTravel) {
            this.canTravel = canTravel;
            return this;
        }

        public TutorPreferencesBuilder setOnlineSession(boolean onlineSession) {
            this.onlineSession = onlineSession;
            return this;
        }

        public TutorPreferencesBuilder setFaceTofaceSession(boolean faceTofaceSession) {
            this.faceTofaceSession = faceTofaceSession;
            return this;
        }

        public TutorPreferencesBuilder setProvidesProjectHelp(boolean providesProjectHelp) {
            this.providesProjectHelp = providesProjectHelp;
            return this;
        }

        public TutorPreferencesBuilder setMinFee(double minFee) {
            this.minFee = minFee;
            return this;
        }

        public TutorPreferencesBuilder setMaxFee(double maxFee) {
            this.maxFee = maxFee;
            return this;
        }

        public TutorPreferencesBuilder copy(TutorPreferences copy) {
            this.id = copy.id;
            this.canTravel = copy.canTravel;
            this.onlineSession = copy.onlineSession;
            this.faceTofaceSession = copy.faceTofaceSession;
            this.providesProjectHelp = copy.providesProjectHelp;
            this.minFee = copy.minFee;
            this.maxFee = copy.maxFee;
            return this;
        }

        public TutorPreferences build() {
            return new TutorPreferences(this);
        }
    }
}
