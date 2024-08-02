# langchain4j-sample

This is a sample portlet which uses langchain4j as a dependency.

It is meant to show how to `compileInclude` langchain4j and its transitive dependencies
into an OSGi module.

This is not in any ways production ready.

If I were building a production-quality version, I'd have a Configuration interface for capturing the various API keys used by the different platforms,
maybe a selector for the one(s) that I want to enable, or individual Configurations to specify the language model that I wanted to use.

I'd also create a generic interface and one or more implementation components, but separate them out to encapsulate the embedding and use of langchain4j.

This way multiple other modules (including this sample portlet) could leverage the components and not have a direct dependency on langchain4j.

But of course, that would be my implementation. Your implementation is up to you, but this can demonstrate how to get the job done.

## Notes

There's two files that should be highlighted:

`modules/langchain4j-web/bnd.bnd` - This is the file defining the OSGi portion of the module. It has an `Include-Package` declaration to exclude some transitive dependency packages of
langchain4j that are not needed in the runtime. It also has a `-fixupmessages` directive to accommodate the Multi-Release jars that langchain4j provides but BND/OSGi does not support.

`modules/langchain4j-web/build.gradle` - This file uses the `compileInclude` directive to embed the langchain4j dependencies inside of the module jar when it is being built. Couldn't be simpler.

`modules/langchain4j-web/src/main/java/com/liferay/community/langchain4j/sample/impl/OpenAITextGeneratorImpl.java` - This file is where to stick your API key.

`modules/langchain4j-web/src/main/java/com/liferay/community/langchain4j/sample/portlet/Langchain4jWebPortlet.java` - Demonstrates using `@Reference` to wire up the dependency for use in the portlet.

Otherwise this portlet is very, very simple.