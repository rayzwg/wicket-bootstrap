package de.agilecoders.wicket.core.markup.html.bootstrap.html;

import de.agilecoders.wicket.core.WicketApplicationTest;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

/**
 * Tests the {@link MetaTag} component
 *
 * @author miha
 */
public class MetaTagTest extends WicketApplicationTest {
    static final String MARKUP = "<meta wicket:id=\"id\"/>";

    @Test(expected = WicketRuntimeException.class)
    public void tagNameIsAsserted() throws Exception {
        startComponentInPage(new MetaTag(id(), Model.of("name"), Model.of("")));
    }

    @Test
    public void nameIsRendered() throws Exception {
        TagTester tag = startComponentInPage(new MetaTag(id(), Model.of("name-of-meta-tag"), Model.of("")), MARKUP);

        assertThat(tag.getAttribute("name"), is(equalTo("name-of-meta-tag")));
    }

    @Test
    public void contentIsRendered() throws Exception {
        TagTester tag = startComponentInPage(new MetaTag(id(), "name-of-meta-tag", "content-of-meta-tag"), MARKUP);

        assertThat(tag.getAttribute("content"), is(equalTo("content-of-meta-tag")));
    }

    @Test
    public void httpEquivNamesAreUsed() throws Exception {
        TagTester tag = startComponentInPage(new MetaTag(id(), "content-type", "text/html"), MARKUP);

        assertThat(tag.getAttribute("http-equiv"), is(equalTo("content-type")));
    }

    @Test
    public void typeSetterWillBeUsed() throws Exception {
        TagTester tag = startComponentInPage(new MetaTag(id(), "name-of-meta-tag", "text/html").type(MetaTag.Type.HttpEquiv), MARKUP);

        assertThat(tag.getAttribute("http-equiv"), is(equalTo("name-of-meta-tag")));
    }
}
