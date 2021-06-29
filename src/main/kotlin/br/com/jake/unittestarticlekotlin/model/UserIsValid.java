package br.com.jake.unittestarticlekotlin.model;

public final class UserIsValid {

    public Boolean userValidation(User user) {
        return !user.getEndereco().isEmpty();
    }

    private UserIsValid() {

    }

    public static UserIsValid.Builder builder() {
        return new UserIsValid.BuilderImpl();
    }

    static final class BuilderImpl implements Builder {
        private BuilderImpl() {

        }

        public UserIsValid build() {
            return new UserIsValid();
        }
    }

    public interface Builder {
        UserIsValid build();
    }
}
