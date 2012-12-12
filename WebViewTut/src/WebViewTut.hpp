// Default empty project template
#ifndef WebViewTut_HPP_
#define WebViewTut_HPP_

#include <QObject>

namespace bb { namespace cascades { class Application; }}

/*!
 * @brief Application pane object
 *
 *Use this object to create and init app UI, to create context objects, to register the new meta types etc.
 */
class WebViewTut : public QObject
{
    Q_OBJECT
public:
    WebViewTut(bb::cascades::Application *app);
    virtual ~WebViewTut() {}
};


#endif /* WebViewTut_HPP_ */
