@import de.lakinator.lakijtesite.model.PageContext
@import de.lakinator.lakijtesite.home.VisitorInfoDTO

@param PageContext pageContext
@param VisitorInfoDTO visitorInfo

@template.layout(pageContext = pageContext,
content = @`
    <hr>
    <section>
        <header>
            <h2>Visitor Stats</h2>
            <p>No cookies involved</p>
        </header>
        <aside>
            <h3>This site has been visited
                <mark>${visitorInfo.count()}</mark>
                times
            </h3>
            <p>Not unique views</p>
        </aside>
    </section>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`
)