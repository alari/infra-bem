package infra.bem

import groovy.transform.CompileStatic

/**
 * @author alari
 * @since 2/5/13 10:45 AM
 */
@CompileStatic
class BemBuilder {
    private BemTagLib bem

    private static final Closure EMPTY = {}
    private Map<String,BemTaglibWrapper> taglibsByPrefix = [:]

    static String getBlockTemplate(String blockName) {
        "/bem/${blockName.replace('-', '/')}"
    }

    BemBuilder(BemTagLib bem) {
        this.bem = bem
    }

    def methodMissing(String name, Collection args) {
        String template = getBlockTemplate(name)
        Map model = [:]
        Map modifiers = [:]
        Map attrs = [:]
        Closure body = EMPTY

        if (args) {

            if (args?.first() instanceof Map) {
                Map argsMap = (Map)args.first()
                if (argsMap.containsKey("_")) {
                    model =  (Map)argsMap.remove("_")
                }
                if (argsMap.containsKey("_attrs")) {
                    attrs = (Map)argsMap.remove("_attrs")
                }
                modifiers = argsMap
            }

            if (args?.last() instanceof Closure) {
                body = (Closure)args.last()
                body.delegate = this
                body.resolveStrategy = Closure.DELEGATE_FIRST
            }
        }

        bem.buildBlock(name, template, body, modifiers, model, attrs)
    }

    def propertyMissing(String name) {
        // Underscored taglibs works like default ones -- to use them in attributes
        if (name.startsWith("_")) {
            return bem.propertyMissing(name.substring(1))
        }
        // Taglibs are wrapped to write to output instead of returning
        if (!taglibsByPrefix.containsKey(name)) {
            taglibsByPrefix.put(name, new BemTaglibWrapper(bem.propertyMissing(name), bem.out))
        }
        taglibsByPrefix.get(name)
    }
}
