package de.agilecoders.wicket.core.markup.html.references;

import de.agilecoders.wicket.core.util.Dependencies;
import de.agilecoders.wicket.webjars.request.resource.WebjarsJavaScriptResourceReference;
import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;

import java.util.List;

/**
 * TODO: document
 *
 * @author miha
 * @version 1.0
 */
public class BootstrapJavaScriptReference extends WebjarsJavaScriptResourceReference {
    private static final long serialVersionUID = 1L;

    /**
     * Singleton instance of this reference
     */
    private static final BootstrapJavaScriptReference INSTANCE = new BootstrapJavaScriptReference();


    /**
     * Normally you should not use this method, but use
     * {@link de.agilecoders.wicket.core.settings.IBootstrapSettings#getJsResourceReference()} to prevent version conflicts.
     *
     * @return the single instance of the resource reference
     */
    public static BootstrapJavaScriptReference instance() {
        return INSTANCE;
    }

    /**
     * Private constructor.
     */
    private BootstrapJavaScriptReference() {
        super("/bootstrap/current/js/bootstrap.js");
    }

    @Override
    public List<HeaderItem> getDependencies() {
        return Dependencies.combine(super.getDependencies(),
                                    JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()),
                                    JavaScriptHeaderItem.forReference(JQueryMigrateJavaScriptReference.INSTANCE));
    }
}
