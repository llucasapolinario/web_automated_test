package pages.Manager;

import pages.HomePage;

public class ManagerPage extends HomePage {

    protected static final String MANEGER_USER_HREF = "Gerenciar Usuários";
    protected static final String MANEGER_PROJECTS_HREF = "Gerenciar Projetos";
    protected static final String MANEGER_TAGS_HREF = "Gerenciar Marcadores";
    protected static final String MANEGER_CUSTON_FIELD_HREF = "Gerenciar Campos Personalizados";
    protected static final String MANEGER_PROF_MENU_HREF = "Gerenciar Perfís Globais";
    protected static final String MANEGER_PLUGIN_HREF = "Gerenciar Plugins";
    protected static final String MANEGER_PERMITIONS_HREF = "Gerenciar Configuração";

    protected static final String ERROR_CODE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[1]";
    protected static final String ERROR_MESSAGE_XPATH = "(.//*[normalize-space(text()) and normalize-space(.)='administrador'])[1]/following::p[2]";

}
