package de.agilecoders.wicket.extensions.markup.html.bootstrap.jqueryui;

import java.util.List;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;

import de.agilecoders.wicket.core.util.Dependencies;
import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;

/**
 * represents a reference to the jquery-ui javascript resource
 *
 * @author miha
 */
public class JqueryUIAllJavaScriptReference extends WebjarsJavaScriptResourceReference {
    private static final long serialVersionUID = 1L;

    /**
     * Singleton instance of this reference
     */
    private static final JqueryUIAllJavaScriptReference INSTANCE = new JqueryUIAllJavaScriptReference();

    /**
     * Private constructor.
     */
    private JqueryUIAllJavaScriptReference() {
        super("jquery-ui/current/ui/minified/jquery-ui.min.js");
    }

    @Override
    public List<HeaderItem> getDependencies() {
        return Dependencies.combine(super.getDependencies(),
                                    JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()));
    }

    /**
     * @return the single instance of the resource reference
     */
    public static JqueryUIAllJavaScriptReference instance() {
        return INSTANCE;
    }

    /**
     * @return this resource reference singleton instance as header item
     */
    public static HeaderItem asHeaderItem() {
        return JavaScriptHeaderItem.forReference(instance());
    }
}
