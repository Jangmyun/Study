


function subject(){
    document.querySelector('#subject').innerHTML = `
    <header>
        <h1>WEB</h1>
        Hello,Web
    </header>
    `;
}

function toc(){
    var state = store.getState();
    let liTitles = ``;
    state.contents.forEach(element => {
        liTitles +=   `
            <li>
                <a onclick="
                    event.preventDefault();
                    let action = {type:'SELECT', id:${element.id}};
                    store.dispatch(action);
                " href="${element.id}">${element.title}</a>
            </li>
        `
    });

    document.querySelector('#toc').innerHTML = `
    <nav>
        <ol>
            ${liTitles}
        </ol>
    </nav>
    `;
}

function control() {
    let state = store.getState();
    document.querySelector('#control').innerHTML=`
    <ul>
        <li><a onclick="
            event.preventDefault();
            store.dispatch({
                type: 'CREATEBUTTON', mode:'create'
            })
        " href="/create">create</a></li>
        <li><input type="button" value="delete" onclick="
            store.dispatch({
                type: 'DELETE'
            })
        "></li>
    </ul>
    `;
}

function article(){
    let state = store.getState();
    if(state.mode === 'create'){
        document.querySelector('#article').innerHTML = `
        <article>
            <form onsubmit="
                    event.preventDefault();
                    let title = this.title.value;
                    let desc = this.desc.value;
                    store.dispatch({
                        type:'CREATE',
                        title:title,
                        desc:desc
                    })
                ">
                <p>
                    <input type="text" name="title" placeholder="title">
                </p>
                <p>
                    <textarea name="desc" placeholder="description" id="" cols="30" rows="10"></textarea>
                </p>
                <p>
                    <input type="submit" value="submit">
                </p>
                
            </form>
        </article>
        `;
    } else if (state.mode === 'read'){
        let articleTitle;
        let articleDesc;
        for(let i=0; i<state.contents.length; i++){
            if(state.contents[i].id == state.selected_id){
                articleTitle = state.contents[i].title;
                articleDesc = state.contents[i].desc;
            }
        }
        document.querySelector('#article').innerHTML=`
            <article>
                <h2>${articleTitle}</h2>
                <p>${articleDesc}</p>
            </article>
        `;
    } else if (state.mode === 'welcome'){
        document.querySelector('#article').innerHTML=`
        <article>
            <h2>Welcome</h2>
            <p>Hello, redux</p>
        </article>
        `;
    }
    
}

function reducer( state, action){
    if(state === undefined){
        return {
            max_id:2,
            mode:'welcome',
            selected_id: 1,
            contents: [
                {id:1, title:'HTML', desc:'HTML is ...'},
                {id:2, title:'CSS', desc: 'CSS is ...'}
            ]
        }
    }
    var newState = {};
    if(action.type === 'SELECT'){
        newState = Object.assign({}, state, {selected_id: action.id , mode:'read'})
    }

    if(action.type === 'CREATE'){
        let newMaxId = state.max_id +1;
        let newContents = state.contents.concat();
        newContents.push({ id: newMaxId, title:action.title, desc:action.desc})
        newState = Object.assign({}, state, {
            max_id: newMaxId,
            contents:newContents,
            mode:'read'
        })
    }
    if(action.type === 'CREATEBUTTON'){
        newState = Object.assign({}, state, {mode:'create'});
    }
    if(action.type === 'DELETE'){
        var newContents= [];
        for(let i=0; i<state.contents.length; i++){
            if(state.selected_id !== state.contents[i].id){
                newContents.push(
                    state.contents[i]
                );
            }
        }
        newState = Object.assign({}, state, {
            contents:newContents,
            mode:'welcome',
        });
    }
    console.log(action, state, newState);
    return newState;
}

let store = Redux.createStore(reducer);
store.subscribe(article);
store.subscribe(toc);

subject();
toc();
control()
article();

