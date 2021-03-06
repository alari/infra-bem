package infra.bem

import infra.bem.manager.MatchingFilesManager
import infra.bem.manager.MovingFilesManager

class BemManagerService {

    static transactional = false



    void lookupBlock(String basedir, String blockName) {

        MatchingFilesManager manager = new MatchingFilesManager(basedir, blockName)

        println "Looking up b-${blockName}..."

        println "Resource config:"

        manager.printConfMatches()

        println();

        println "Views:"
        manager.printViewsMatches()

        println()

        println "Static resources:"
        manager.printStaticsMatches()
        println()
    }

    void moveBlock(String basedir, String blockName, String moveToBlockName) {
        MovingFilesManager manager = new MovingFilesManager(basedir, blockName, moveToBlockName)

        println "Renaming b-${blockName} to b-${moveToBlockName}..."

        println "replacing in views..."
        manager.modifyViews()

        println "replacing in statics..."
        manager.modifyStatics()

        println()
        println "Done!"
        println()

        println """
*****************************************************
*                                                   *
*                 W A R N I N G                     *
*                                                   *
*****************************************************

    It's just a Stupid Mechanism doing Dirty Work.
           You MUST check the changelog
        and test your project: it may fail.
              (Be happy if it won't!)
"""
    }


}
